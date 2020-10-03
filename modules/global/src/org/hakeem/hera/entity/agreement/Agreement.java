package org.hakeem.hera.entity.agreement;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.PartyRelationship;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "HERA_AGREEMENT")
@Entity(name = "hera_Agreement")
@NamePattern("%s|code")
public class Agreement extends StandardEntity {
    private static final long serialVersionUID = -4586924211354231932L;

    @Column(name = "CODE", length = 100)
    private String code;

    @Column(name="AGREEMENT_DATE")
    private LocalDate agreementDate;

    @Column(name="FROM_DATE")
    private  LocalDate fromDate;

    @Column(name="THRU_DATE")
    private LocalDate thruDate;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="AGREEMENT_TYPE")
    private String agreementType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_RELATIONSHIP_ID")
    private PartyRelationship partyRelationship;


    @Column(name = "TEXTUAL")
    private String textual;


    public LocalDate getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(LocalDate agreementDate) {
        this.agreementDate = agreementDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PartyRelationship getPartyRelationship() {
        return partyRelationship;
    }

    public void setPartyRelationship(PartyRelationship partyRelationship) {
        this.partyRelationship = partyRelationship;
    }

    public String getTextual() {
        return textual;
    }

    public void setTextual(String textual) {
        this.textual = textual;
    }

    public AgreementType getAgreementType() {
        return agreementType == null ? null : AgreementType.fromId(agreementType);
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType == null ? null : agreementType.getId();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}