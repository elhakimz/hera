package org.hakeem.hera.web.screens.attendance;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.timesheet.Attendance;
import org.hakeem.hera.entity.timesheet.AttendanceType;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("hera_Attendance.browse")
@UiDescriptor("attendance-browse.xml")
@LookupComponent("attendancesTable")
@LoadDataBeforeShow
public class AttendanceBrowse extends StandardLookup<Attendance> {

    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionContainer<Attendance> attendancesDc;
    @Inject
    private DataGrid<Attendance> attendancesTable;
    @Inject
    private CollectionLoader<Attendance> attendancesDl;

    @Subscribe
    public void onInit(InitEvent event) {
        attendancesDl.load();
        initHeader();

    }


    @Subscribe("attendancesTable.create")
    public void onAttendancesTableCreate(Action.ActionPerformedEvent event) {
       Attendance att=createAttendance();
       attendancesTable.setSelected(att);
    }

    private Attendance createAttendance(){
        Attendance att = dataContext.create(Attendance.class);
        att.setAttendanceType(AttendanceType.PRESENT);
        att.setFromDateTime(LocalDateTime.now());
        attendancesDc.getMutableItems().add(att);
        return att;
    }

    @Subscribe(id = "attendancesDc", target = Target.DATA_CONTAINER)
    public void onAttendancesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Attendance> event) {
        dataContext.commit();
    }

    private void initHeader(){
        DataGrid.HeaderRow headerRow = attendancesTable.prependHeaderRow();
        DataGrid.HeaderCell headerCell = headerRow.join("fromDateTime","toDateTime");
        headerCell.setText("Present Date Time");
        headerCell.setStyleName("center-bold");
    }

    @Subscribe(id = "attendancesDc", target = Target.DATA_CONTAINER)
    public void onAttendancesDcItemChange(InstanceContainer.ItemChangeEvent<Attendance> event) {
        dataContext.commit();
    }
}