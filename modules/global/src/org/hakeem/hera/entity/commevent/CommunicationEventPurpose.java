package org.hakeem.hera.entity.commevent;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "HERA_COMMUNICATION_EVENT_PURPOSE")
@Entity(name = "hera_CommunicationEventPurpose")
public class CommunicationEventPurpose extends StandardEntity {
    private static final long serialVersionUID = -4378858162980424577L;

    @Column(name = "DESCRIPTION")
    private String description;

    @JoinColumn(name="COMMEVENTPURPOSETYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CommunicationEventPurposeType communicationEventPurposeType;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommunicationEventPurposeType getCommunicationEventPurposeType() {
        return communicationEventPurposeType;
    }

    public void setCommunicationEventPurposeType(CommunicationEventPurposeType communicationEventPurposeType) {
        this.communicationEventPurposeType = communicationEventPurposeType;
    }
}