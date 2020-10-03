package org.hakeem.hera.web.screens.holiday;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.timesheet.Holiday;

import javax.inject.Inject;
import java.time.LocalDate;

@UiController("hera_Holiday.browse")
@UiDescriptor("holiday-browse.xml")
@LookupComponent("holidaysTable")
@LoadDataBeforeShow
public class HolidayBrowse extends StandardLookup<Holiday> {

    @Inject
    private DataContext dataContext;

    @Inject
    private CollectionContainer<Holiday> holidaysDc;

    @Inject
    private GroupTable<Holiday> holidaysTable;

    @Subscribe("holidaysTable.create")
    public void onHolidaysTableCreate(Action.ActionPerformedEvent event) {
        Holiday holiday=createHoliday();
        holidaysTable.setSelected(holiday);
    }

    private Holiday createHoliday(){
        Holiday holiday= dataContext.create(Holiday.class);
        holiday.setDateOfHoliday(LocalDate.now());
        holiday.setName("Name of holiday");
        holiday.setDescription("");
        holidaysDc.getMutableItems().add(holiday);
        return holiday;
    }

    @Subscribe(id = "holidaysDc", target = Target.DATA_CONTAINER)
    public void onHolidaysDcCollectionChange(CollectionContainer.CollectionChangeEvent<Holiday> event) {
          dataContext.commit();
    }

    @Subscribe(id = "holidaysDc", target = Target.DATA_CONTAINER)
    public void onHolidaysDcItemChange(InstanceContainer.ItemChangeEvent<Holiday> event) {
        dataContext.commit();
    }


}