package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_EMPLOYEE_RANK")
@Entity(name = "hera_EmployeeRank")
@NamePattern("%s|rankType,employee")
public class EmployeeRank extends StandardEntity {
    private static final long serialVersionUID = 4813844160432203789L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMPLYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RANK_TYPE_ID")
    private  RankType rankType;

    @Column(name = "PROMOTIONDATE")
    private LocalDate promotionDate;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public RankType getRankType() {
        return rankType;
    }

    public void setRankType(RankType rankType) {
        this.rankType = rankType;
    }

    public LocalDate getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(LocalDate promotionDate) {
        this.promotionDate = promotionDate;
    }
}