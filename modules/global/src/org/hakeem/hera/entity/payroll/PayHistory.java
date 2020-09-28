package org.hakeem.hera.entity.payroll;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.Employment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "HERA_PAY_HISTORY")
@Entity(name = "hera_PayHistory")
@NamePattern("%s|description")
public class PayHistory extends StandardEntity {
    private static final long serialVersionUID = -2263803783762850595L;

    @Column(name = "FRON_DATE")
    private LocalDate fronDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYMENT_ID")
    private Employment employment;

    @Column(name = "PERIOD_TYPE")
    private String periodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALARY_STEP_ID")
    private SalaryStep salaryStep;

    public SalaryStep getSalaryStep() {
        return salaryStep;
    }

    public void setSalaryStep(SalaryStep salaryStep) {
        this.salaryStep = salaryStep;
    }

    public PeriodType getPeriodType() {
        return periodType == null ? null : PeriodType.fromId(periodType);
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType == null ? null : periodType.getId();
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDate getFronDate() {
        return fronDate;
    }

    public void setFronDate(LocalDate fronDate) {
        this.fronDate = fronDate;
    }
}