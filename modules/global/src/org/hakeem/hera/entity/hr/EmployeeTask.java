package org.hakeem.hera.entity.hr;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "HERA_EMPLOYEE_TASK")
@Entity(name = "hera_EmployeeTask")
public class EmployeeTask extends StandardEntity {
    private static final long serialVersionUID = 7733317892279143468L;

    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


}