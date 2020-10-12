package org.hakeem.hera.web.screens.questionairetype;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.QuestionaireType;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.UUID;

@UiController("hera_QuestionaireType.browse")
@UiDescriptor("questionaire-type-browse.xml")
@LookupComponent("questionaireTypesTable")
@LoadDataBeforeShow
public class QuestionaireTypeBrowse extends StandardLookup<QuestionaireType> {

    @Inject
    DataContext dataContext;

    @Inject
    private CollectionContainer<QuestionaireType> questionaireTypesDc;

    @Inject
    private GroupTable<QuestionaireType> questionaireTypesTable;

    @Subscribe("questionaireTypesTable.create")
    public void onQuestionaireTypesTableCreate(Action.ActionPerformedEvent event) {
       QuestionaireType qt= addQuestionaireType();
       questionaireTypesTable.setSelected(qt);
    }

    private QuestionaireType addQuestionaireType(){
           QuestionaireType qt = dataContext.create(QuestionaireType.class);
           qt.setId(UUID.randomUUID());
           qt.setValidFrom(LocalDate.now());
           qt.setName("");
           qt.setDescription("");
           questionaireTypesDc.getMutableItems().add(qt);
           return qt;
    }

    @Subscribe(id = "questionaireTypesDc", target = Target.DATA_CONTAINER)
    public void onQuestionaireTypesDcItemChange(InstanceContainer.ItemChangeEvent<QuestionaireType> event) {
        dataContext.commit();
    }

    @Subscribe(id = "questionaireTypesDc", target = Target.DATA_CONTAINER)
    public void onQuestionaireTypesDcCollectionChange(CollectionContainer.CollectionChangeEvent<QuestionaireType> event) {
        dataContext.commit();
    }

}