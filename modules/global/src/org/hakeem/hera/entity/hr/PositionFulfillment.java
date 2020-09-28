package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.slf4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_POSITION_FULFILLMENT")
@Entity(name = "hera_PositionFulfillment")
@NamePattern("%s|name")
public class PositionFulfillment extends StandardEntity {
    private static final long serialVersionUID = -4750770496795497245L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PositionFulfillment.class);

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Transient
    @MetaProperty(related = "fulfillmentOf")
    private String name;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Lob
    @Column(name = "NOTE")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCEPTED_BY_ID")
    private Employee acceptedBy;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FULFILLMENT_OF_ID")
    private Position fulfillmentOf;

    public void setAcceptedBy(Employee acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public Employee getAcceptedBy() {
        return acceptedBy;
    }

    public String getName() {
        try {
            if(getFulfillmentOf()!=null){
                name=(getFulfillmentOf()!=null ? getFulfillmentOf().getName():"?")
                        + " by "+ (getAcceptedBy()!=null? getAcceptedBy().getName():"?");

            }
        } catch (Exception e) {
            log.error("Error", e);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getFulfillmentOf() {
        return fulfillmentOf;
    }

    public void setFulfillmentOf(Position fulfillmentOf) {
        this.fulfillmentOf = fulfillmentOf;
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
}