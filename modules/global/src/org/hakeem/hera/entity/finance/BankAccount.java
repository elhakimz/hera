package org.hakeem.hera.entity.finance;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.Party;

import javax.persistence.*;
import java.util.List;

@Table(name = "HERA_BANK_ACCOUNT")
@Entity(name = "hera_BankAccount")
@NamePattern("%s|name")
public class BankAccount extends StandardEntity {
    private static final long serialVersionUID = 7172731126728758203L;

    @MetaProperty
    @Transient
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @OneToMany(mappedBy = "bankAccount")
    private List<BankAccountNumber> accountNumbers;

    public List<BankAccountNumber> getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(List<BankAccountNumber> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}