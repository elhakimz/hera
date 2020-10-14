package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.common.Task;

import javax.persistence.*;
import java.time.LocalDate;

@javax.persistence.DiscriminatorValue("EMPLOYEE_TASK")
@Entity(name = "hera_EmployeeTask")
@NamePattern("%s|name")
public class EmployeeTask extends Task {
    private static final long serialVersionUID = 7733317892279143468L;

    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee toEmployee;

    @JoinColumn(name = "FROM_EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee delegatedFrom;

    @JoinColumn(name = "FWD_EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee forwardedTo;

    @Column(name = "FORWARD_DATE")
    private LocalDate forwardDate;


    public Employee getToEmployee() {
        return toEmployee;
    }

    public void setToEmployee(Employee toEmployee) {
        this.toEmployee = toEmployee;
    }

    public Employee getDelegatedFrom() {
        return delegatedFrom;
    }

    public void setDelegatedFrom(Employee delegatedFrom) {
        this.delegatedFrom = delegatedFrom;
    }

    public Employee getForwardedTo() {
        return forwardedTo;
    }

    public void setForwardedTo(Employee forwardedTo) {
        this.forwardedTo = forwardedTo;
    }

    public LocalDate getForwardDate() {
        return forwardDate;
    }

    public void setForwardDate(LocalDate forwardDate) {
        this.forwardDate = forwardDate;
    }
}