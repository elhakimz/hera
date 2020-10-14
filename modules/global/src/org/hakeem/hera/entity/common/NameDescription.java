package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@javax.persistence.DiscriminatorValue("NAMEDESCRIPTION")
@Table(name = "HERA_NAME_DESCRIPTION")
@Entity(name = "hera_NameDescription")
@NamePattern("%s|name")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class NameDescription extends StandardEntity {
    private static final long serialVersionUID = 5870210466877327772L;

    @NotNull
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALIDFROM")
    private LocalDate validFrom;

    @Column(name = "VALIDUNTIL")
    private LocalDate validUntil;

    @Column(name="LANG", length = 10)
    private String language;

    @Column(name = "CODE")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}