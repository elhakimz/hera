package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "HERA_POSITION_TYPE")
@Entity(name = "hera_PositionType")
@NamePattern("%s|name")
public class PositionType extends StandardEntity {
    private static final long serialVersionUID = 9068817301488824894L;

    @Column(name = "NAME", nullable = false, length = 100)
    @NotNull
    private String name;

    @Column(name = "CODE", length = 10)
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BENEFIT_PERCENT")
    private Double benefitPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @OneToMany(mappedBy = "positionType")
    private List<PositionTypeClass> positionTypeClasses;

    public List<PositionTypeClass> getPositionTypeClasses() {
        return positionTypeClasses;
    }

    public void setPositionTypeClasses(List<PositionTypeClass> positionTypeClasses) {
        this.positionTypeClasses = positionTypeClasses;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBenefitPercent() {
        return benefitPercent;
    }

    public void setBenefitPercent(Double benefitPercent) {
        this.benefitPercent = benefitPercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}