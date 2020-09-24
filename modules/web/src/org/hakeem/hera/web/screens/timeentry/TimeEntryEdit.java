package org.hakeem.hera.web.screens.timeentry;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.timesheet.TimeEntry;

@UiController("hera_TimeEntry.edit")
@UiDescriptor("time-entry-edit.xml")
@EditedEntityContainer("timeEntryDc")
@LoadDataBeforeShow
public class TimeEntryEdit extends StandardEditor<TimeEntry> {
}