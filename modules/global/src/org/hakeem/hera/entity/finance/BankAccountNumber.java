package org.hakeem.hera.entity.finance;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_BANK_ACCOUNT_NUMBER")
@Entity(name = "hera_BankAccountNumber")
@NamePattern("%s|accountNo")
public class BankAccountNumber extends StandardEntity {
    private static final long serialVersionUID = -6465260734307764609L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private BankAccount bankAccount;

    @Column(name = "NUMBER_TYPE")
    private String numberType;

    @Column(name = "ACCOUNT_NO", length = 100)
    private String accountNo;

    @Column(name = "COMPACT_ACCOUNT_NO", length = 100)
    private String compactAccountNo;

    @Column(name = "EXPIRE_DATE")
    private LocalDate expireDate;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCompactAccountNo() {
        return compactAccountNo;
    }

    public void setCompactAccountNo(String compactAccountNo) {
        this.compactAccountNo = compactAccountNo;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public AccountNumberType getNumberType() {
        return numberType == null ? null : AccountNumberType.fromId(numberType);
    }

    public void setNumberType(AccountNumberType numberType) {
        this.numberType = numberType == null ? null : numberType.getId();
    }
}