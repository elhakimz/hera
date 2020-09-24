package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "HERA_TIME_ENTRY")
@Entity(name = "hera_TimeEntry")
@NamePattern("%s|entryId")
public class TimeEntry extends StandardEntity {
    private static final long serialVersionUID = 740238613056514899L;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIMESHEET_ID")
    private Timesheet timesheet;

    @Column(name = "ENTRY_ID", length = 100)
    private String entryId;

    @Column(name = "FROM_DATE_TIME", nullable = false)
    @NotNull
    private LocalDateTime fromDateTime;

    @Column(name = "THRU_DATE_TIME")
    private LocalDateTime thruDateTime;

    @Column(name = "HOURS")
    private Double hours;

    @Column(name = "NOTE")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKEFFORT_ID")
    private Workeffort workeffort;

    public Workeffort getWorkeffort() {
        return workeffort;
    }

    public void setWorkeffort(Workeffort workeffort) {
        this.workeffort = workeffort;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public LocalDateTime getThruDateTime() {
        return thruDateTime;
    }

    public void setThruDateTime(LocalDateTime thruDateTime) {
        this.thruDateTime = thruDateTime;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }
}