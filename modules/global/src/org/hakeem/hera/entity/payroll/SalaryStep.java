package org.hakeem.hera.entity.payroll;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "HERA_SALARY_STEP")
@Entity(name = "hera_SalaryStep")
public class SalaryStep extends StandardEntity {
    private static final long serialVersionUID = -3893732885025321025L;

    @Column(name = "SEQ_ID")
    private Integer seqId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DATE_MODIFIED")
    private LocalDate dateModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAY_GRADE_ID")
    private PayGrade payGrade;

    public PayGrade getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(PayGrade payGrade) {
        this.payGrade = payGrade;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }
}