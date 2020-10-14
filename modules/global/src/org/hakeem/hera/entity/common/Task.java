package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.types.PriorityType;
import org.hakeem.hera.entity.types.TaskStatusType;

import javax.persistence.*;
import java.time.LocalDate;

@javax.persistence.DiscriminatorValue("TASK")
@Table(name = "HERA_TASK")
@Entity(name = "hera_Task")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@NamePattern("%s|name")
public class Task extends StandardEntity {
    private static final long serialVersionUID = -7814865274229892938L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TODO")
    @Lob
    private String todo;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE")
    private LocalDate toDate;

    @Column(name = "PRIORITY_TYPE")
    private String  priorityType;


    @Column(name = "TASK_STATUS_TYPE")
    private String taskStatusType;


    @Column(name = "PROCESS_STATE")
    private String processState;


    @Column(name = "PROCESS_DATE")
    private String processDate;

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public String getProcessState() {
        return processState;
    }


    public void setTaskStatusType(TaskStatusType taskStatusType) {
        this.taskStatusType = taskStatusType==null? null : taskStatusType.getId();
    }

    public TaskStatusType getTaskStatusType() {
        return taskStatusType==null ? null : TaskStatusType.fromId(taskStatusType);
    }

    public void setPriorityType(PriorityType priorityType) {
        this.priorityType= priorityType==null ? null :  priorityType.getId();
    }

    public PriorityType getPriorityType() {
        return priorityType==null ?  null : PriorityType.fromId(priorityType);
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

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}