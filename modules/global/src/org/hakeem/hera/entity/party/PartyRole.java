package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import org.slf4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;

@PublishEntityChangedEvents
@DiscriminatorValue("ROLE")
@Table(name = "HERA_PARTY_ROLE")
@Entity(name = "hera_PartyRole")
@NamePattern("%s|name")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class PartyRole extends StandardEntity {
    private static final long serialVersionUID = -2053731754971987258L;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PartyRole.class);

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @JoinColumn(name = "PARTYROLETYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PartyRoleType partyRoleType;

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

    @PreUpdate
    public void preUpdate() {
          if(name==null || name.isEmpty()) {
              try {
                  name=  getPartyRoleType().getName();
              } catch (Exception e) {
                  log.error("Error", e);
              }
          }
    }

    public PartyRoleType getPartyRoleType() {
        return partyRoleType;
    }

    public void setPartyRoleType(PartyRoleType partyRoleType) {
        this.partyRoleType = partyRoleType;
    }
}