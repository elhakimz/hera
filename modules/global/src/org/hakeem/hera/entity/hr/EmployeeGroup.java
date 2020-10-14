package org.hakeem.hera.entity.hr;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.common.NameDescription;

import javax.persistence.Entity;
import javax.persistence.Table;

@javax.persistence.DiscriminatorValue("EMPLOYEE_GROUP")
@Entity(name = "hera_EmployeeGroup")
public class EmployeeGroup extends NameDescription {
    private static final long serialVersionUID = -3072872439531133496L;
}