package org.hakeem.hera.web.screens.person;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.QuestionType;
import org.hakeem.hera.entity.common.QuestionaireResult;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.entity.hr.EmploymentApplyStep;
import org.hakeem.hera.entity.hr.Position;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.entity.types.EmploymentApplyStepType;
import org.hakeem.hera.service.QuestionaireService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
    private Metadata metadata;

    @Inject
    private CollectionContainer<QuestionaireResult> questionsDc;

    @Inject
    protected QuestionaireService questionaireService;

    private Position selectedPosition;

    @Subscribe
    public void onInit(InitEvent event) {
        Person p = metadata.create(Person.class);
        setEntityToEdit(p);

        questionTable.addGeneratedColumn("result",entity -> {
            return createColumnComponent(entity.getQuestionType(),entity);
        });

        List<QuestionaireResult> qlist=questionaireService.generateQuestionaireList("Interview");

        for(QuestionaireResult result:qlist){
            result.setPerson(getEditedEntity());
        }
        questionsDc.getMutableItems().addAll(qlist);
    }

    @Subscribe("btnCommitAndClose")
    public void onBtnCommitAndCloseClick(Button.ClickEvent event) {
        createEmployeeApplication();
        closeWithCommit();
    }

    private Component createColumnComponent(QuestionType questionType,  QuestionaireResult result){

        if(questionType==QuestionType.BOOLEAN){
            CheckBox cb = uiComponents.create(CheckBox.class);
            cb.addValueChangeListener(booleanValueChangeEvent -> result.setResult(booleanValueChangeEvent.getValue().toString()));
            return cb;
        }else if(questionType==QuestionType.TEXT){
            TextField tf= uiComponents.create(TextField.TYPE_STRING);
             tf.setWidth("100%");
             tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> result.setResult((String) valueChangeEvent.getValue()));
           return tf;
        }else if(questionType==QuestionType.DATE){
            DateField df =uiComponents.create(DateField.TYPE_DATE);
            df.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> result.setResult(valueChangeEvent.getValue().toString()));
            return df;
        }else if(questionType==QuestionType.NUMBER){
            TextField tf = uiComponents.create(TextField.TYPE_DOUBLE);
            tf.setWidth("100%");
            tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                    valueChangeEvent -> result.setResult((String) valueChangeEvent.getValue()));
            return tf;
        }
        TextField tf = uiComponents.create(TextField.TYPE_STRING);
        tf.setWidth("100%");
        tf.addValueChangeListener((Consumer<HasValue.ValueChangeEvent>)
                valueChangeEvent -> result.setResult((String) valueChangeEvent.getValue()));
        return tf;
    }

    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
    protected void onQuestionsDcCollectionChange(CollectionContainer.CollectionChangeEvent<QuestionaireResult> event) {
        dataContext.commit();
    }

    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
    protected void onQuestionsDcItemChange(InstanceContainer.ItemChangeEvent<QuestionaireResult> event) {
        dataContext.commit();
    }

    @Subscribe(id = "questionsDc", target = Target.DATA_CONTAINER)
    protected void onQuestionsDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<QuestionaireResult> event) {
        dataContext.commit();
    }


    private void createEmployeeApplication(){

        CommitContext commitContext = new CommitContext();
        EmploymentApplication ea=dataManager.create(EmploymentApplication.class);
        ea.setCode("APPL-"+LocalDate.now());
        ea.setFromPerson(getEditedEntity());
        ea.setApplyDate(LocalDate.now());

        List<QuestionaireResult> qrs = questionsDc.getMutableItems();
        StringBuilder descr = new StringBuilder();

        qrs.forEach(qr -> {
            descr.append(qr.getQuestionaireItem().getQuestion())
                    .append(": ").append(qr.getResult()).append("\r\n");
        });

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

        qrs.forEach(qr -> {
           QuestionaireResult res=dataManager.create(QuestionaireResult.class);
           res.setEmploymentApplication(ea);
           res.setResult(qr.getResult());
           res.setPerson(getEditedEntity());
           res.setQuestionType(qr.getQuestionType());
           res.setOnDate(qr.getOnDate());
           commitContext.addInstanceToCommit(res);
         });

        commitContext.addInstanceToCommit(ea).addInstanceToCommit(applyStep);
        dataManager.commit(commitContext);
    }

    @Subscribe("positionWantedField")
    protected void onPositionWantedFieldValueChange(HasValue.ValueChangeEvent<Position> event) {
        selectedPosition = event.getValue();
    }


}