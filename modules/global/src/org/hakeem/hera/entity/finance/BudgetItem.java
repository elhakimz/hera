package org.hakeem.hera.entity.finance;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "HERA_BUDGET_ITEM")
@Entity(name = "hera_BudgetItem")
public class BudgetItem extends StandardEntity {
    private static final long serialVersionUID = 4204793057323795144L;

    @Column(name = "SEQ_ID")
    private Integer seqId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PURPOSE", length = 100)
    private String purpose;

    @Lob
    @Column(name = "JUSTIFICATION")
    private String justification;

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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