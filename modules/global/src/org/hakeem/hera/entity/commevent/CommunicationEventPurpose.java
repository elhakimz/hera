package org.hakeem.hera.entity.commevent;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.slf4j.Logger;

import javax.persistence.*;

@Table(name = "HERA_COMMUNICATION_EVENT_PURPOSE")
@Entity(name = "hera_CommunicationEventPurpose")
@NamePattern("%s|name, description")
public class CommunicationEventPurpose extends StandardEntity {
    private static final long serialVersionUID = -4378858162980424577L;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CommunicationEventPurpose.class);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMUNICATIONEVENT_ID")
    private CommunicationEvent communicationEvent;

    @Column(name = "DESCRIPTION")
    private String description;

    @JoinColumn(name="COMMEVENTPURPOSETYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CommunicationEventPurposeType communicationEventPurposeType;

    @MetaProperty
    @Transient
    private String name;


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

    public CommunicationEvent getCommunicationEvent() {
        return communicationEvent;
    }

    public void setCommunicationEvent(CommunicationEvent communicationEvent) {
        this.communicationEvent = communicationEvent;
    }

    public String getName() {

        try {
            name=  getCommunicationEventPurposeType().getName();
        } catch (Exception e) {
            log.error("Error", e);
        }

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}