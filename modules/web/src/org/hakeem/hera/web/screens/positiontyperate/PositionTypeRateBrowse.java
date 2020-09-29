package org.hakeem.hera.web.screens.positiontyperate;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import org.hakeem.hera.entity.payroll.PeriodType;
import org.hakeem.hera.entity.payroll.PositionTypeRate;
import org.hakeem.hera.entity.payroll.RateType;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;

@UiController("hera_PositionTypeRate.browse")
@UiDescriptor("position-type-rate-browse.xml")
@LookupComponent("positionTypeRatesTable")
@LoadDataBeforeShow
public class PositionTypeRateBrowse extends StandardLookup<PositionTypeRate> {
    @Inject
    private CollectionContainer<PositionTypeRate> positionTypeRatesDc;

    @Inject
    private DataContext dataContext;

    @Inject
    private Table<PositionTypeRate> positionTypeRatesTable;

    @Inject
    private UiComponents uiComponents;

    @Subscribe("positionTypeRatesTable.create")
    public void onPositionTypeRatesTableCreate(Action.ActionPerformedEvent event) {
         onCreateNewRate();
    }

    private void onCreateNewRate(){
        PositionTypeRate ptr = dataContext.create(PositionTypeRate.class);
        ptr.setPeriodType(PeriodType.MONTHLY);
        ptr.setRateType(RateType.STANDARD);
        ptr.setRate(new BigDecimal(0));
        ptr.setFromDate(LocalDate.now());
        positionTypeRatesDc.getMutableItems().add(ptr);
        positionTypeRatesTable.setSelected(ptr);
    }

    @Subscribe(id = "positionTypeRatesDc", target = Target.DATA_CONTAINER)
    public void onPositionTypeRatesDcCollectionChange(CollectionContainer.CollectionChangeEvent<PositionTypeRate> event) {
        dataContext.commit();
    }

    @Subscribe(id = "positionTypeRatesDc", target = Target.DATA_CONTAINER)
    public void onPositionTypeRatesDcItemChange(InstanceContainer.ItemChangeEvent<PositionTypeRate> event) {
        dataContext.commit();

    }

    public Component generateCurrencyCell(PositionTypeRate entity){
        CurrencyField<BigDecimal> cf=uiComponents.create(CurrencyField.TYPE_BIGDECIMAL);
        cf.setValue(entity.getRate());
        cf.setWidthFull();
        cf.addValueChangeListener(bigDecimalValueChangeEvent -> entity.setRate(bigDecimalValueChangeEvent.getValue()));
        return cf;
    }

}