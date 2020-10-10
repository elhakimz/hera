package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "HERA_EMPLOYEE_REQUEST")
@Entity(name = "hera_EmployeeRequest")
@NamePattern("%s|employeeRequestType")
public class EmployeeRequest extends StandardEntity {
    private static final long serialVersionUID = 6392696211053641626L;

    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(name = "EMPLOYEEREQUESTTYPE")
    private String employeeRequestType;

    @Column(name = "PROCESSSTATE")
    private String processState;

    @Column(name = "PROCESSDATE")
    private LocalDate processDate;

    @Column(name = "ISSUEDATE")
    private LocalDate issueDate;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "REQUESTFROMDATE")
    private LocalDate requestFromDate;

    @Column(name = "REQUESTTODATE")
    private LocalDate requestToDate;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;


    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return manager;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getRequestFromDate() {
        return requestFromDate;
    }

    public void setRequestFromDate(LocalDate requestFromDate) {
        this.requestFromDate = requestFromDate;
    }

    public LocalDate getRequestToDate() {
        return requestToDate;
    }

    public void setRequestToDate(LocalDate requestToDate) {
        this.requestToDate = requestToDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public EmployeeRequestType getEmployeeRequestType(){
        return employeeRequestType==null ? null: EmployeeRequestType.fromId(employeeRequestType);
    }

    public void setEmployeeRequestType(EmployeeRequestType employeeRequestType){
        this.employeeRequestType = employeeRequestType==null ? null: employeeRequestType.getId();
    }
}