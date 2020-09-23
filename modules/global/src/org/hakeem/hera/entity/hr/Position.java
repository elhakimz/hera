package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hakeem.hera.entity.finance.BudgetItem;
import org.hakeem.hera.entity.party.Organization;
import org.hakeem.hera.entity.types.StatusType;
import org.slf4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Table(name = "HERA_POSITION")
@Entity(name = "hera_Position")
@NamePattern("%s|name")
public class Position extends StandardEntity {
    private static final long serialVersionUID = -6056909315643645701L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Position.class);

    @Column(name = "EST_FROM_DATE")
    private LocalDate estFromDate;

    @Column(name = "EST_THRU_DATE")
    private LocalDate estThruDate;

    @Column(name = "HAS_SALARY")
    private Boolean hasSalary;

    @Column(name = "IS_EXEMPT")
    private Boolean isExempt;

    @Column(name = "IS_FULL_TIME")
    private Boolean isFullTime;

    @Column(name = "IS_TEMPORARY")
    private Boolean isTemporary;

    @Column(name = "ACT_FROM_DATE")
    private LocalDate actFromDate;

    @Column(name = "ACT_THRU_DATE")
    private LocalDate actThruDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POSITION_TYPE_ID")
    @NotNull
    private PositionType positionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUDGET_ITEM_ID")
    private BudgetItem budgetItem;

    @Transient
    @MetaProperty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WITHIN_ORGANIZATION_ID")
    private Organization withinOrganization;

    @Column(name = "STATUS_TYPE")
    private String statusType;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "position")
    private List<PositionResponsibility> positionResponsibilities;

    @OneToMany(mappedBy = "fulfillmentOf")
    private List<PositionFulfillment> positionFulfillments;

    public List<PositionFulfillment> getPositionFulfillments() {
        return positionFulfillments;
    }

    public void setPositionFulfillments(List<PositionFulfillment> positionFulfillments) {
        this.positionFulfillments = positionFulfillments;
    }

    public void setActThruDate(LocalDate actThruDate) {
        this.actThruDate = actThruDate;
    }

    public LocalDate getActThruDate() {
        return actThruDate;
    }

    public List<PositionResponsibility> getPositionResponsibilities() {
        return positionResponsibilities;
    }

    public void setPositionResponsibilities(List<PositionResponsibility> positionResponsibilities) {
        this.positionResponsibilities = positionResponsibilities;
    }

    public StatusType getStatusType() {
        return statusType == null ? null : StatusType.fromId(statusType);
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType == null ? null : statusType.getId();
    }

    public Organization getWithinOrganization() {
        return withinOrganization;
    }

    public void setWithinOrganization(Organization withinOrganization) {
        this.withinOrganization = withinOrganization;
    }

    public String getName() {

        try {
            if(getPositionType()!=null){
                name=getPositionType().getName();
            }
        } catch (Exception e) {
            log.error("Error", e);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BudgetItem getBudgetItem() {
        return budgetItem;
    }

    public void setBudgetItem(BudgetItem budgetItem) {
        this.budgetItem = budgetItem;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public LocalDate getActFromDate() {
        return actFromDate;
    }

    public void setActFromDate(LocalDate actFromDate) {
        this.actFromDate = actFromDate;
    }

    public Boolean getIsTemporary() {
        return isTemporary;
    }

    public void setIsTemporary(Boolean isTemporary) {
        this.isTemporary = isTemporary;
    }

    public Boolean getIsFullTime() {
        return isFullTime;
    }

    public void setIsFullTime(Boolean isFullTime) {
        this.isFullTime = isFullTime;
    }

    public Boolean getIsExempt() {
        return isExempt;
    }

    public void setIsExempt(Boolean isExempt) {
        this.isExempt = isExempt;
    }

    public Boolean getHasSalary() {
        return hasSalary;
    }

    public void setHasSalary(Boolean hasSalary) {
        this.hasSalary = hasSalary;
    }

    public LocalDate getEstThruDate() {
        return estThruDate;
    }

    public void setEstThruDate(LocalDate estThruDate) {
        this.estThruDate = estThruDate;
    }

    public LocalDate getEstFromDate() {
        return estFromDate;
    }

    public void setEstFromDate(LocalDate estFromDate) {
        this.estFromDate = estFromDate;
    }
}