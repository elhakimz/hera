package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;

@DiscriminatorValue("ROLE")
@Table(name = "HERA_PARTY_ROLE")
@Entity(name = "hera_PartyRole")
@NamePattern("%s|name")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class PartyRole extends StandardEntity {
    private static final long serialVersionUID = -2053731754971987258L;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

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

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

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
}