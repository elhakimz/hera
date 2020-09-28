package org.hakeem.hera.entity.payroll;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.PositionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "HERA_POSITION_TYPE_RATE")
@Entity(name = "hera_PositionTypeRate")
public class PositionTypeRate extends StandardEntity {
    private static final long serialVersionUID = 4746748662824356032L;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Column(name = "RATE")
    private BigDecimal rate;

    @Column(name = "RATE_TYPE")
    private String rateType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_TYPE_ID")
    private PositionType positionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALARY_STEP_ID")
    private SalaryStep salaryStep;

    public SalaryStep getSalaryStep() {
        return salaryStep;
    }

    public void setSalaryStep(SalaryStep salaryStep) {
        this.salaryStep = salaryStep;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public RateType getRateType() {
        return rateType == null ? null : RateType.fromId(rateType);
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType == null ? null : rateType.getId();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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
}