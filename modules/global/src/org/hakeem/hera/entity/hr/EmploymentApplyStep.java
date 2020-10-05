package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.types.HiringStepType;
import org.hakeem.hera.entity.types.MaritalStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_EMPLOYMENT_APPL_STEP")
@Entity(name = "hera_EmploymentApplStep")
@NamePattern("%s - %s|employmentApplication,hiringStepType")
public class EmploymentApplyStep extends StandardEntity {
    private static final long serialVersionUID = 5273674598750184221L;

    @JoinColumn(name = "EMPLOYMENTAPPLICATION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmploymentApplication employmentApplication;

    @Column(name = "STEPDATE")
    private LocalDate stepDate;

    @Column(name = "HIRINGSTEPTYPE")
    private String hiringStepType;

    @Column(name = "DESCRIPTION")
    private String description;

    public LocalDate getStepDate() {
        return stepDate;
    }

    public void setStepDate(LocalDate stepDate) {
        this.stepDate = stepDate;
    }


    public void setHiringStepType(String hiringStepType) {
        this.hiringStepType = hiringStepType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmploymentApplication getEmploymentApplication() {
        return employmentApplication;
    }

    public void setEmploymentApplication(EmploymentApplication employmentApplication) {
        this.employmentApplication = employmentApplication;
    }

    public void setHiringStepType(HiringStepType hiringStepType){
        this.hiringStepType = hiringStepType == null ? null : hiringStepType.getId();
    }

    public HiringStepType getHiringStepType(){
        return hiringStepType == null ? null : HiringStepType.fromId(hiringStepType);
    }
}