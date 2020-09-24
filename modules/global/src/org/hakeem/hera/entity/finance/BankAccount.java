package org.hakeem.hera.entity.finance;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "HERA_BANK_ACCOUNT")
@Entity(name = "hera_BankAccount")
public class BankAccount extends StandardEntity {
    private static final long serialVersionUID = 7172731126728758203L;
}