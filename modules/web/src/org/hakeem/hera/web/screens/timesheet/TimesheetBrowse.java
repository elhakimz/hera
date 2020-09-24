package org.hakeem.hera.web.screens.timesheet;

import com.haulmont.cuba.gui.components.EditableChangeNotifier;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.timesheet.TimeEntry;
import org.hakeem.hera.entity.timesheet.Timesheet;

import javax.inject.Inject;

@UiController("hera_Timesheet.browse")
@UiDescriptor("timesheet-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class TimesheetBrowse extends MasterDetailScreen<Timesheet> {
    @Inject
    private Table<TimeEntry> timeEntriesTable;


    @Inject
    private Form form;

    @Subscribe("form")
    public void onFormEditableChange(EditableChangeNotifier.EditableChangeEvent event) {
            timeEntriesTable.setEnabled(event.getSource().isEditable());
    }


}