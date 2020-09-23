package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hakeem.hera.entity.types.ContactType;

import javax.persistence.*;

@Table(name = "HERA_PARTY_CONTACT")
@Entity(name = "hera_PartyContact")
@NamePattern("%s|contactNumber")
public class PartyContact extends StandardEntity {
    private static final long serialVersionUID = 8351422690720304503L;

    @Column(name = "CONTACT_TYPE")
    private String contactType;

    @Column(name = "CONTACT_NUMBER", length = 100)
    private String contactNumber;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    private Party party;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public ContactType getContactType() {
        return contactType == null ? null : ContactType.fromId(contactType);
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType == null ? null : contactType.getId();
    }
}