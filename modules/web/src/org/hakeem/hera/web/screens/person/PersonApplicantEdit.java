package org.hakeem.hera.web.screens.person;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.QuestionType;
import org.hakeem.hera.entity.common.QuestionaireItem;
import org.hakeem.hera.entity.common.QuestionaireResult;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.entity.hr.EmploymentApplyStep;
import org.hakeem.hera.entity.hr.Position;
import org.hakeem.hera.entity.party.PartyRole;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.entity.types.EmploymentApplyStepType;
import org.hakeem.hera.service.PartyService;
import org.hakeem.hera.service.QuestionaireService;

import javax.inject.Inject;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@UiController("hera_PersonApplicant.edit")
@UiDescriptor("person-applicant-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonApplicantEdit extends StandardEditor<Person> {
    @Inject
    protected UiComponents uiComponents;
    @Inject
    protected Table<QuestionaireResult> questionTable;
    @Inject
    protected DataContext dataContext;
    @Inject
    protected DataManager dataManager;
    @Inject
    protected Notifications notifications;

    @Inject
    private Metadata metadata;

    @Inject
    private CollectionContainer<QuestionaireResult> questionsDc;

    @Inject
    protected QuestionaireService questionaireService;

    @Inject
    protected PartyService partyService;

    @Inject
    protected UniqueNumbersService uniqueNumbersService;

    private Position selectedPosition;

    @Subscribe
    public void onInit(InitEvent event) {
        Person p = metadata.create(Person.class);
        setEntityToEdit(p);

        List<QuestionaireResult> qlist=questionaireService.generateQuestionaireList("Interview");

        for(QuestionaireResult result:qlist){
            result.setPerson(getEditedEntity());
        }
        questionsDc.setItems(qlist);
    }

    @Subscribe("btnCommitAndClose")
    public void onBtnCommitAndCloseClick(Button.ClickEvent event) {
        createEmployeeApplication();
        closeWithCommit();
    }

    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
    protected void onQuestionsDcCollectionChange(CollectionContainer.CollectionChangeEvent<QuestionaireResult> event) {
        dataContext.commit();
    }

    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
    protected void onQuestionsDcItemChange(InstanceContainer.ItemChangeEvent<QuestionaireResult> event) {
        dataContext.commit();
    }



    private void createEmployeeApplication(){

        PartyRole partyRole = partyService.createPartyRole("PERSON");

        if(partyRole!=null){
            partyRole.setParty(getEditedEntity());
            dataContext.merge(partyRole);
            List<PartyRole> roles = new ArrayList<>();
            getEditedEntity().setPartyRoles(roles);
            getEditedEntity().getPartyRoles().add(partyRole);
        }
        dataContext.merge(getEditedEntity());

        final EmploymentApplication ea=dataManager.create(EmploymentApplication.class);

        ea.setCode("APPL-"+uniqueNumbersService.getNextNumber(EmploymentApplication.class.getSimpleName()));
        ea.setFromPerson(getEditedEntity());
        ea.setApplyDate(LocalDate.now());

        List<QuestionaireResult> qrs = questionsDc.getMutableItems();
        StringBuilder descr = new StringBuilder();

        qrs.forEach(qr -> descr.append(qr.getQuestionaireItem().getQuestion())
                .append(": ").append(qr.getResult()).append("\r\n"));

        ea.setDescription(descr.toString());
        ea.setPosition(selectedPosition);
        List<EmploymentApplyStep> eas=new ArrayList<>();
        EmploymentApplyStep applyStep = dataManager.create(EmploymentApplyStep.class);
        applyStep.setEmploymentApplication(ea);
        applyStep.setDescription(EmploymentApplyStepType.SOURCED.getId());
        applyStep.setStepDate(LocalDate.now());
        applyStep.setEmploymentApplyStepType(EmploymentApplyStepType.SOURCED);
        ea.setSteps(eas);
        ea.setLastStep(EmploymentApplyStepType.SOURCED.getId());
        dataContext.merge(ea);
        dataContext.merge(applyStep);

        for(QuestionaireResult qr:qrs){
             qr.setEmploymentApplication(ea);
             dataContext.merge(qr);
        }
        dataContext.commit();
        notifications.create(Notifications.NotificationType.TRAY).withCaption("Employment Application has been created").show();
    }

    @Subscribe("positionWantedField")
    protected void onPositionWantedFieldValueChange(HasValue.ValueChangeEvent<Position> event) {
        selectedPosition = event.getValue();
    }


    public Component generateResultCell(QuestionaireResult entity) {
        QuestionType questionType = entity.getQuestionType();
        TextField tf;
        if(questionType==QuestionType.TEXT){
             tf= uiComponents.create(TextField.TYPE_STRING);
            tf.setWidthFull();
            tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> entity.setResult(String.valueOf(valueChangeEvent.getValue()))
            );
            return tf;
        }else  if(questionType==QuestionType.NUMBER){
             tf = uiComponents.create(TextField.TYPE_DOUBLE);
            tf.setWidthFull();
            tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> entity.setResult(String.valueOf(valueChangeEvent.getValue()))
            );

            return tf;
        }else  if(questionType==QuestionType.MONEY){
            CurrencyField cf = uiComponents.create(CurrencyField.TYPE_BIGDECIMAL);
            cf.setWidthFull();
            cf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> entity.setResult(String.valueOf(valueChangeEvent.getValue()))
            );

            return cf;
        }else{
            tf = uiComponents.create(TextField.TYPE_STRING);
            tf.setWidthFull();
            tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> entity.setResult(String.valueOf(valueChangeEvent.getValue()))
            );

        }
        return tf;
    }

//    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
//    protected void onQuestionsDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<QuestionaireResult> event) {
//        dataContext.merge(event.getItem());
//    }

}