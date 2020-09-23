package org.hakeem.hera.entity.hr;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_POSITION_TYPE_CLASS")
@Entity(name = "hera_PositionTypeClass")
public class PositionTypeClass extends StandardEntity {
    private static final long serialVersionUID = 7918189878471325880L;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate;

    @Column(name = "THRU_DATE")
    private LocalDate thruDate;

    @Column(name = "STANDARD_HOURS_PER_WEEK")
    private Double standardHoursPerWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASSIFICATION_TYPE_ID")
    @Lookup(type = LookupType.DROPDOWN, actions = {})
    private PositionClassificationType classificationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_TYPE_ID")
    private PositionType positionType;

    public void setStandardHoursPerWeek(Double standardHoursPerWeek) {
        this.standardHoursPerWeek = standardHoursPerWeek;
    }

    public Double getStandardHoursPerWeek() {
        return standardHoursPerWeek;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public PositionClassificationType getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(PositionClassificationType classificationType) {
        this.classificationType = classificationType;
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
}