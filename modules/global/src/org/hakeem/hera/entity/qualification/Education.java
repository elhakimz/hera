package org.hakeem.hera.entity.qualification;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.entity.types.QualificationType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "HERA_EDUCATION")
@Entity(name = "hera_Education")
@NamePattern("%s|name")
public class Education extends StandardEntity {
    private static final long serialVersionUID = -1236607760095912365L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @NotNull
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="FROM_DATE")
    private LocalDate fromDate;

    @Column(name="TO_DATE")
    private LocalDate toDate;

    @Column(name="QUALIFICATION_TYPE")
    private String qualificationType;

    @Column(name = "BRANCHOFSTUDY")
    private String branchOfStudy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public QualificationType getQualificationType() {
        return qualificationType == null ? null : QualificationType.fromId(qualificationType);
    }

    public void setQualificationType(QualificationType qualificationType) {
        this.qualificationType = qualificationType == null ? null : qualificationType.getId();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBranchOfStudy() {
        return branchOfStudy;
    }

    public void setBranchOfStudy(String branchOfStudy) {
        this.branchOfStudy = branchOfStudy;
    }
}