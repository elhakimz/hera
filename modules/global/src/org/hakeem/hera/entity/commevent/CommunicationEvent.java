package org.hakeem.hera.entity.commevent;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.PartyRelationship;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_COMMUNICATION_EVENT")
@Entity(name = "hera_CommunicationEvent")
public class CommunicationEvent extends StandardEntity {
    private static final long serialVersionUID = -1318671849905999645L;

    @Column(name="FROM_DATE")
    private LocalDate fromDate;

    @Column(name="TO_DATE")
    private LocalDate toDate;

    @Column(name = "NOTE")
    private String note;

    @JoinColumn(name = "PARTYRELATIONSHIP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PartyRelationship partyRelationship;

    @Column(name = "STATUS_TYPE")
    private String statusType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACTMECHTYPE_ID")
    private ContactMechanismType contactMechanismType;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public PartyRelationship getPartyRelationship() {
        return partyRelationship;
    }

    public void setPartyRelationship(PartyRelationship partyRelationship) {
        this.partyRelationship = partyRelationship;
    }

    private CommunicationEventStatusType getStatusType(){
        return statusType==null? null : CommunicationEventStatusType.fromId(statusType);
     }

    private void setStatusType(CommunicationEventStatusType statusType){
        this.statusType = statusType == null ? null : statusType.getId();
    }

    public ContactMechanismType getContactMechanismType() {
        return contactMechanismType;
    }

    public void setContactMechanismType(ContactMechanismType contactMechanismType) {
        this.contactMechanismType = contactMechanismType;
    }
}