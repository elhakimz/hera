package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.entity.types.SourceType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "HERA_EMPLOYMENT_APPLICATION")
@Entity(name = "hera_EmploymentApplication")
@NamePattern("%s|code")
public class EmploymentApplication extends StandardEntity {
    private static final long serialVersionUID = 1247731668178665864L;

    @NotNull
    @Column(name = "CODE", length = 10)
    private String code;

    @Column(name = "APPLYDATE")
    private LocalDate applyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="POSITION_ID")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROMPERSON_ID")
    private Person fromPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFERPERSON_ID")
    private Person referPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOURCETYPE_ID")
    private SourceType sourceType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name="PROCESS_STATE")
    private String processState;

    @Column(name="PROCESS_DATE")
    private LocalDate processDate;

    @Column(name = "LAST_STEP")
    private String lastStep;

    @OneToMany(mappedBy = "employmentApplication")
    private List<EmploymentApplyStep> steps;

    public void setLastStep(String lastStep) {
        this.lastStep = lastStep;
    }

    public String getLastStep() {
        return lastStep;
    }


    public void setSteps(List<EmploymentApplyStep> steps) {
        this.steps = steps;
    }

    public List<EmploymentApplyStep> getSteps() {
        return steps;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public LocalDate getProcessDate() {
        return processDate;
    }

    public void setProcessDate(LocalDate processDate) {
        this.processDate = processDate;
    }

    public LocalDate getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDate applyDate) {
        this.applyDate = applyDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Person getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(Person fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Person getReferPerson() {
        return referPerson;
    }

    public void setReferPerson(Person referPerson) {
        this.referPerson = referPerson;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}