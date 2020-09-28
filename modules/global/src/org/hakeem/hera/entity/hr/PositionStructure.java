package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.types.StatusType;
import org.slf4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "HERA_POSITION_STRUCTURE")
@Entity(name = "hera_PositionStructure")
public class PositionStructure extends StandardEntity {
    private static final long serialVersionUID = -2567796695324479638L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PositionStructure.class);

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POSITION_ID")
    @NotNull
    private Position reportTo;

    @Column(name = "REPORT_TO_NAME", length = 100)
    private String reportToName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGED_BY_ID")
    private Position managedBy;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Transient
    @MetaProperty
    private String name;

    @Column(name = "IS_PRIMARY")
    private Boolean isPrimary;

    @Column(name = "STATUS")
    private String status;

    public String getReportToName() {
        return reportToName;
    }

    public void setReportToName(String reportToName) {
        this.reportToName = reportToName;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public StatusType getStatus() {
        return status == null ? null : StatusType.fromId(status);
    }

    public void setStatus(StatusType status) {
        this.status = status == null ? null : status.getId();
    }

    public String getName() {
        try {

            name= (getManagedBy()!=null ? getManagedBy().getName():"?")
                    +" -> "+(getReportTo()!=null ? getReportTo().getName():"?");
        } catch (Exception e) {
            log.error("Error", e);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public Position getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Position managedBy) {
        this.managedBy = managedBy;
    }

    public Position getReportTo() {
        return reportTo;
    }

    public void setReportTo(Position reportTo) {
        this.reportTo = reportTo;
    }

    @PrePersist
    public void prePersist() {

        try {
            setReportToName(getReportTo().getName());
        } catch (Exception e) {
            log.error("Error", e);
        }
    }

    @PreUpdate
    public void preUpdate() {
        try {
            setReportToName(getReportTo().getName());
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}