package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.Employee;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name = "HERA_ATTENDANCE")
@Entity(name = "hera_Attendance")
public class Attendance extends StandardEntity {
    private static final long serialVersionUID = -3044039629414966553L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "FROM_DATE_TIME")
    private LocalDateTime fromDateTime;

    @Column(name = "TO_DATE_TIME")
    private LocalDateTime toDateTime;

    @Column(name = "ATTENDANCE_TYPE")
    private String attendanceType;

    @Column(name = "HAS_PERMIT")
    private Boolean hasPermit;

    @Column(name = "LEAVE_TIME")
    private LocalTime leaveTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEAVE_PERMITTED_BY_ID")
    private Employee leavePermittedBy;

    @MetaProperty
    @Transient
    private Double presentHours;

    @Transient
    @MetaProperty
    private String extraHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXTRA_HOUR_PERMITTED_BY_ID")
    private Employee extraHoursPermittedBy;

    @Column(name = "EXTRA_HOURS_REASON")
    private String extraHoursReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIMESHEET_ID")
    private Timesheet timesheet;

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    public String getExtraHoursReason() {
        return extraHoursReason;
    }

    public void setExtraHoursReason(String extraHoursReason) {
        this.extraHoursReason = extraHoursReason;
    }

    public Employee getExtraHoursPermittedBy() {
        return extraHoursPermittedBy;
    }

    public void setExtraHoursPermittedBy(Employee extraHoursPermittedBy) {
        this.extraHoursPermittedBy = extraHoursPermittedBy;
    }

    public String getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(String extraHours) {
        this.extraHours = extraHours;
    }

    public Employee getLeavePermittedBy() {
        return leavePermittedBy;
    }

    public void setLeavePermittedBy(Employee leavePermittedBy) {
        this.leavePermittedBy = leavePermittedBy;
    }

    public Double getPresentHours() {
        return presentHours;
    }

    public void setPresentHours(Double presentHours) {
        this.presentHours = presentHours;
    }

    public LocalTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Boolean getHasPermit() {
        return hasPermit;
    }

    public void setHasPermit(Boolean hasPermit) {
        this.hasPermit = hasPermit;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType == null ? null : AttendanceType.fromId(attendanceType);
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType == null ? null : attendanceType.getId();
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}