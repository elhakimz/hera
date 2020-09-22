package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NamePattern("%s|name")
public class Organization extends Party {
    private static final long serialVersionUID = 7062370672113295566L;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}