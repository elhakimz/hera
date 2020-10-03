package org.hakeem.hera.web.screens.attendance;

import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.calendar.CalendarEvent;
import com.haulmont.cuba.gui.components.calendar.CalendarEventProvider;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import org.hakeem.hera.entity.hr.Employee;
import org.hakeem.hera.entity.party.Party;
import org.hakeem.hera.entity.timesheet.Attendance;
import org.hakeem.hera.entity.timesheet.TimeEntry;
import org.hakeem.hera.entity.timesheet.Timesheet;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@UiController("hera_AttendanceCalendar.browse")
@UiDescriptor("attendance-calendar-browse.xml")
@LookupComponent("attendanceCalendar")
@LoadDataBeforeShow
public class AttendanceCalendarBrowse extends StandardLookup<Attendance> {

    @Inject
    private DataContext dataContext;

    @Inject
    private Notifications notifications;

    @Inject
    private Calendar<LocalDateTime> attendanceCalendar;

    @Inject
    protected UiComponents uiComponents;

    private Attendance currentAttendance;
    @Inject
    private InstanceContainer<Attendance> attendanceDc;
    @Inject
    private CollectionContainer<TimeEntry> timeEntriesDc;

    @Inject
    private InstanceContainer<Timesheet> timesheetDc;
    @Inject
    private Calendar<LocalDateTime> timeEntriesCalendar;
    @Inject
    private CollectionContainer<Employee> employeesDc;
    @Inject
    private Table<Employee> employeeTable;
    @Inject
    private CollectionLoader<Attendance> attendancesDl;

    @Subscribe
    public void onInit(InitEvent event) {
       employeeTable.addGeneratedColumn("image",this::renderAvatarImageComponent);
       employeeTable.setColumnHeaderVisible(false);
       employeeTable.setColumnControlVisible(false);

    }

    private Component renderAvatarImageComponent(Employee employee) {
        Party party = employee.getParty();
        if(party == null) return null;

        FileDescriptor imageFile = party.getPhotoImage();
        if (imageFile == null) {
            return null;
        }
        Image image = smallAvatarImage();
        image.setSource(FileDescriptorResource.class)
                .setFileDescriptor(imageFile);
        return image;
    }




    @Subscribe(id = "attendancesDc", target = Target.DATA_CONTAINER)
    public void onAttendancesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Attendance> event) {
        if(!event.getSource().getItems().isEmpty()){
            currentAttendance = event.getSource().getItems().get(0);
        }else {
            currentAttendance = null;
        }
    }


    @Subscribe(id = "attendanceDc", target = Target.DATA_CONTAINER)
    public void onAttendanceDcItemChange(InstanceContainer.ItemChangeEvent<Attendance> event) {
        dataContext.commit();
    }

    @Subscribe("attendanceCalendar")
    public void onAttendanceCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        currentAttendance = (Attendance) event.getEntity();
        if(currentAttendance!=null){
            attendanceDc.setItem(currentAttendance);
            if(currentAttendance.getTimesheet()!=null){
                timesheetDc.setItem(currentAttendance.getTimesheet());
            }
        }else{
            notifications.create()
                    .withCaption("No Employee Selected")
                    .withDescription("Select Employee from filter")
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();
        }
    }


    @Subscribe("employeeTable")
    public void onEmployeeTableSelection(Table.SelectionEvent<Employee> event) {
        Employee employee = event.getSource().getSingleSelected();
        if (employee!= null){
            attendancesDl.setQuery("select e from hera_Attendance e where e.employee= :emp");
            attendancesDl.setParameter("emp", employee);
            attendancesDl.load();
        }
    }


    private Image smallAvatarImage() {
        Image image = uiComponents.create(Image.class);
        image.setScaleMode(Image.ScaleMode.CONTAIN);
        image.setHeight("50");
        image.setWidth("50");
        image.setStyleName("avatar-icon-small");
        return image;
    }



}