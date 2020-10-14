package org.hakeem.hera.entity.finance;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import org.hakeem.hera.entity.party.Organization;
import org.slf4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "HERA_BANK")
@Entity(name = "hera_Bank")
@NamePattern("%s|name")
public class Bank extends StandardEntity {
    private static final long serialVersionUID = 4370610131624768940L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Bank.class);

    @MetaProperty
    @Transient
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZATION_ID")
    @NotNull
    private Organization organization;

    @Column(name = "BIC", length = 100)
    private String bic;

    @OneToMany(mappedBy = "bank")
    private List<BankAccount> bankAccounts;

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        try {
            if(getOrganization() != null ){
                name=getOrganization().getName()+(bic!=null ? " ("+bic+")":"");
            }
        } catch (Exception e) {
            log.error("Error", e);
        }

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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