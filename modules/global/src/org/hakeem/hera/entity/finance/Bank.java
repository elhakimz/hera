package org.hakeem.hera.entity.finance;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.Organization;

import javax.persistence.*;

@Table(name = "HERA_BANK")
@Entity(name = "hera_Bank")
public class Bank extends StandardEntity {
    private static final long serialVersionUID = 4370610131624768940L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    @Column(name = "BIC", length = 100)
    private String bic;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}