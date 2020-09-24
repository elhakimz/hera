package org.hakeem.hera.entity.finance;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import org.hakeem.hera.entity.types.Country;

import javax.persistence.*;

@Table(name = "HERA_CURRENCY")
@Entity(name = "hera_Currency")
@NamePattern("%s|name")
public class Currency extends StandardEntity {
    private static final long serialVersionUID = -1154645572373487205L;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "CODE", length = 10)
    private String code;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

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
}