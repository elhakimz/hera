package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "HERA_COUNTRY")
@Entity(name = "hera_Country")
@NamePattern("%s|name")
public class Country extends StandardEntity {
    private static final long serialVersionUID = -5922546117360262786L;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CODE", length = 20)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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