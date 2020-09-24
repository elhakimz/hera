package org.hakeem.hera.entity.payroll;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "HERA_PAYCHECK")
@Entity(name = "hera_Paycheck")
public class Paycheck extends StandardEntity {
    private static final long serialVersionUID = 1470694671535824115L;
}