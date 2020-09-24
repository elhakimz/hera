package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "HERA_WORKEFFORT")
@Entity(name = "hera_Workeffort")
@NamePattern("%s|name")
public class Workeffort extends StandardEntity {
    private static final long serialVersionUID = 6797898106395191348L;

    @Column(name = "NAME", nullable = false, length = 100)
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SCHEDULED_START", nullable = false)
    @NotNull
    private LocalDate scheduledStart;

    @Column(name = "SCHEDULED_COMPLETION", nullable = false)
    @NotNull
    private LocalDate scheduledCompletion;

    @Column(name = "TOTAL_AMOUNT_ALLOWED")
    private BigDecimal totalAmountAllowed;

    @Column(name = "TOTAL_HOURS_ALLOWED")
    private Double totalHoursAllowed;

    @Column(name = "ESTIMATED_HOURS")
    private Double estimatedHours;

    @Column(name = "ACTUAL_START")
    private LocalDate actualStart;

    @Column(name = "ACTUAL_COMPLETION")
    private LocalDate actualCompletion;

    @Column(name = "ACTUAL_HOURS")
    private Double actualHours;

    @Column(name = "SPECIAL_TERMS")
    private String specialTerms;

    public String getSpecialTerms() {
        return specialTerms;
    }

    public void setSpecialTerms(String specialTerms) {
        this.specialTerms = specialTerms;
    }

    public Double getActualHours() {
        return actualHours;
    }

    public void setActualHours(Double actualHours) {
        this.actualHours = actualHours;
    }

    public LocalDate getActualCompletion() {
        return actualCompletion;
    }

    public void setActualCompletion(LocalDate actualCompletion) {
        this.actualCompletion = actualCompletion;
    }

    public LocalDate getActualStart() {
        return actualStart;
    }

    public void setActualStart(LocalDate actualStart) {
        this.actualStart = actualStart;
    }

    public Double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public Double getTotalHoursAllowed() {
        return totalHoursAllowed;
    }

    public void setTotalHoursAllowed(Double totalHoursAllowed) {
        this.totalHoursAllowed = totalHoursAllowed;
    }

    public BigDecimal getTotalAmountAllowed() {
        return totalAmountAllowed;
    }

    public void setTotalAmountAllowed(BigDecimal totalAmountAllowed) {
        this.totalAmountAllowed = totalAmountAllowed;
    }

    public LocalDate getScheduledCompletion() {
        return scheduledCompletion;
    }

    public void setScheduledCompletion(LocalDate scheduledCompletion) {
        this.scheduledCompletion = scheduledCompletion;
    }

    public LocalDate getScheduledStart() {
        return scheduledStart;
    }

    public void setScheduledStart(LocalDate scheduledStart) {
        this.scheduledStart = scheduledStart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}