package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.Employee;
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

    @Column(name = "RESULT_ANSWER")
    private  String result;

    @Column(name = "ON_DATE")
    private LocalDate onDate;

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

}