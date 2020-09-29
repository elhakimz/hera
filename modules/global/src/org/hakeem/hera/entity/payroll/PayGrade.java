package org.hakeem.hera.entity.payroll;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "HERA_PAY_GRADE")
@Entity(name = "hera_PayGrade")
@NamePattern("%s|name")
public class PayGrade extends StandardEntity {
    private static final long serialVersionUID = -1398376195668133266L;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "payGrade")
    private List<SalaryStep> salarySteps;

    public List<SalaryStep> getSalarySteps() {
        return salarySteps;
    }

    public void setSalarySteps(List<SalaryStep> salarySteps) {
        this.salarySteps = salarySteps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}