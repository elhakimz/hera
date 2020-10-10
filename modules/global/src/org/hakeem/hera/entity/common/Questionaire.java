package org.hakeem.hera.entity.common;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.hr.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_QUESTIONAIRE")
@Entity(name = "hera_Questionaire")
public class Questionaire extends StandardEntity {
    private static final long serialVersionUID = 8978722710042235623L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTIONAIRETYPE_ID")
    private QuestionaireType questionaireType;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE")
    private  LocalDate toDate;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAKER_ID")
    private Employee maker;

    @Column(name = "ISSELECTABLE")
    private Boolean isSelectable;

    @Column(name = "IS_MULTI_SELECT")
    private Boolean isMultiSelect;

    @Column(name = "PROCESS_STATE", length = 25)
    private String processState;

    @Column(name = "PROCESS_DATE")
    private LocalDate processDate;

    public void setMultiSelect(Boolean multiSelect) {
        isMultiSelect = multiSelect;
    }

    public Boolean getMultiSelect() {
        return isMultiSelect;
    }

    public void setSelectable(Boolean selectable) {
        isSelectable = selectable;
    }

    public Boolean isSelectable() {
        return isSelectable;
    }

    public void setProcessDate(LocalDate processDate) {
        this.processDate = processDate;
    }

    public LocalDate getProcessDate() {
        return processDate;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public String getProcessState() {
        return processState;
    }

    public void setMaker(Employee maker) {
        this.maker = maker;
    }

    public Employee getMaker() {
        return maker;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setQuestionaireType(QuestionaireType questionaireType) {
        this.questionaireType = questionaireType;
    }

    public QuestionaireType getQuestionaireType() {
        return questionaireType;
    }


}