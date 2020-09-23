package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.types.IdentifierType;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_PARTY_IDENTIFIER")
@Entity(name = "hera_PartyIdentifier")
@NamePattern("%s|identNumber")
public class PartyIdentifier extends StandardEntity {
    private static final long serialVersionUID = 1402444269526595637L;

    @Column(name = "IDENT_TYPE")
    private String identType;

    @Column(name = "IDENT_NUMBER", length = 100)
    private String identNumber;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public IdentifierType getIdentType() {
        return identType == null ? null : IdentifierType.fromId(identType);
    }

    public void setIdentType(IdentifierType identType) {
        this.identType = identType == null ? null : identType.getId();
    }
}