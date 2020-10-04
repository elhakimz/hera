package org.hakeem.hera.entity.qualification;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.entity.types.SkillLevelType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "HERA_SKILL")
@Entity(name = "hera_Skill")
@NamePattern("%s|name")
public class Skill extends StandardEntity {
    private static final long serialVersionUID = -1175694372819076509L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @NotNull
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="YEARS_EXPERIENCE")
    private Integer yearsExperience;

    @Column(name="SKILL_LEVEL_TYPE", length = 100)
    private String skillLevelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SKILL_TYPE_ID")
    private SkillType skillType;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public SkillLevelType getSkillLevelType() {
        return skillLevelType == null ? null : SkillLevelType.fromId(skillLevelType);
    }

    public void setSkillLevelType(SkillLevelType skillLevelType) {
        this.skillLevelType = skillLevelType == null ? null : skillLevelType.getId();
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
}