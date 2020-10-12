package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.Employee;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.entity.party.Person;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_QUESTIONAIRE_RESULT")
@Entity(name = "hera_QuestionaireResult")
@NamePattern("%s|result")
public class QuestionaireResult extends StandardEntity {
    private static final long serialVersionUID = -7786957452718093274L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTIONAIREITEM_ID")
    private QuestionaireItem questionaireItem;

    @Column(name = "QUESTION_TYPE")
    private String questionType;

    @Column(name = "RESULT_ANSWER")
    private  String result;

    @Column(name = "ON_DATE")
    private LocalDate onDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYMENTAPPLICATION_ID")
    private EmploymentApplication employmentApplication;


    public void setEmploymentApplication(EmploymentApplication employmentApplication) {
        this.employmentApplication = employmentApplication;
    }

    public EmploymentApplication getEmploymentApplication() {
        return employmentApplication;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setQuestionaireItem(QuestionaireItem questionaireItem) {
        this.questionaireItem = questionaireItem;
    }

    public QuestionaireItem getQuestionaireItem() {
        return questionaireItem;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType==null? null:questionType.getId();
    }

    public QuestionType getQuestionType() {
        return questionType==null ? null : QuestionType.fromId(questionType);
    }

}