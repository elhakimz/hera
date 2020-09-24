package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hakeem.hera.entity.hr.Employee;
import org.slf4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Table(name = "HERA_TIMESHEET")
@Entity(name = "hera_Timesheet")
@NamePattern("%s|name")
public class Timesheet extends StandardEntity {
    private static final long serialVersionUID = -2062033400599517848L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Timesheet.class);

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "FROM_DATE", nullable = false)
    @NotNull
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Column(name = "NOTE")
    private String note;

    @OneToMany(mappedBy = "timesheet")
    private List<TimeEntry> timeEntries;

    @Transient
    @MetaProperty
    private String name;

    public String getName() {

        try {
            name= getEmployee().getName();
        } catch (Exception e) {
            log.error("Error", e);
        }

        return name+"'s Timesheet ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public void setTimeEntries(List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}