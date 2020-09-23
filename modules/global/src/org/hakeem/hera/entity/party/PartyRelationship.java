package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;

@DiscriminatorValue("RELATIONSHIP")
@Table(name = "HERA_PARTY_RELATIONSHIP")
@Entity(name = "hera_PartyRelationship")
@NamePattern("%s|name")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class PartyRelationship extends StandardEntity {
    private static final long serialVersionUID = -2090731364934802927L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_PARTY_ROLE_ID")
    private PartyRole fromPartyRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_PARTY_ROLE_ID")
    private PartyRole toPartyRole;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PartyRole getToPartyRole() {
        return toPartyRole;
    }

    public void setToPartyRole(PartyRole toPartyRole) {
        this.toPartyRole = toPartyRole;
    }

    public PartyRole getFromPartyRole() {
        return fromPartyRole;
    }

    public void setFromPartyRole(PartyRole fromPartyRole) {
        this.fromPartyRole = fromPartyRole;
    }
}