package org.hakeem.hera.web.screens.paygrade;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.payroll.PayGrade;
import org.hakeem.hera.entity.payroll.SalaryStep;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;

@UiController("hera_PayGrade.browse")
@UiDescriptor("pay-grade-browse.xml")
@LookupComponent("payGradesTable")
@LoadDataBeforeShow
public class PayGradeBrowse extends StandardLookup<PayGrade> {

    @Inject
    DataContext dataContext;
    @Inject
    private Table<PayGrade> payGradesTable;
    @Inject
    private CollectionContainer<PayGrade> payGradesDc;
    @Inject
    private CollectionPropertyContainer<SalaryStep> salaryStepsDc;

    private PayGrade currentPayGrade;

    private void createPayGrade(){
         PayGrade pg = dataContext.create(PayGrade.class);
         pg.setName("");
         pg.setDescription("Pay Grade");
         payGradesDc.getMutableItems().add(pg);
         payGradesTable.setSelected(pg);
    }

    private void createSalaryStep(){
         if(currentPayGrade==null) return;
          SalaryStep ss=dataContext.create(SalaryStep.class);
          ss.setId(UUID.randomUUID());
          ss.setAmount(new BigDecimal(0));
          ss.setSeqId(0);
          ss.setPayGrade(currentPayGrade);
          salaryStepsDc.getMutableItems().add(ss);
    }

    @Subscribe("payGradesTable.create")
    public void onPayGradesTableCreate(Action.ActionPerformedEvent event) {
        createPayGrade();
    }

    @Subscribe(id = "payGradesDc", target = Target.DATA_CONTAINER)
    public void onPayGradesDcCollectionChange(CollectionContainer.CollectionChangeEvent<PayGrade> event) {
        dataContext.commit();
    }


    @Subscribe("payGradesTable")
    public void onPayGradesTableSelection(Table.SelectionEvent<PayGrade> event) {
        currentPayGrade= event.getSource().getSingleSelected();
    }


    @Subscribe("salaryStepsTable.create")
    public void onSalaryStepsTableCreate(Action.ActionPerformedEvent event) {
        createSalaryStep();
    }


}