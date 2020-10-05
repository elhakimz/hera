package org.hakeem.hera.entity.commevent;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.PartyRelationship;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String communicationEventStatusType;

    @JoinColumn(name = "CONTACTMECHTYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ContactMechanismType contactMechanismType;

    @OneToMany(mappedBy = "communicationEvent")
    private List<CommunicationEventPurpose> communicationEventPurposes;

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

    public CommunicationEventStatusType getCommunicationEventStatusType(){
        return communicationEventStatusType ==null? null : CommunicationEventStatusType.fromId(communicationEventStatusType);
     }

    public void setCommunicationEventStatusType(CommunicationEventStatusType communicationEventStatusType){
        this.communicationEventStatusType = communicationEventStatusType == null ? null : communicationEventStatusType.getId();
    }

    public ContactMechanismType getContactMechanismType() {
        return contactMechanismType;
    }

    public void setContactMechanismType(ContactMechanismType contactMechanismType) {
        this.contactMechanismType = contactMechanismType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<CommunicationEventPurpose> getCommunicationEventPurposes() {
        return communicationEventPurposes;
    }

    public void setCommunicationEventPurposes(List<CommunicationEventPurpose> communicationEventPurposes) {
        this.communicationEventPurposes = communicationEventPurposes;
    }
}