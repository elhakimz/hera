package org.hakeem.hera.entity.commevent;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "HERA_CONTACT_MECHANISM_TYPE")
@Entity(name = "hera_ContactMechanismType")
public class ContactMechanismType extends StandardEntity {
    private static final long serialVersionUID = -1354935529892616007L;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

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
}