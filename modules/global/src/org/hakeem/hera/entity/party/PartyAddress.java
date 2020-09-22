package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hakeem.hera.entity.types.Country;

import javax.persistence.*;

@Table(name = "HERA_PARTY_ADDRESS")
@Entity(name = "hera_PartyAddress")
@NamePattern("%s|city")
public class PartyAddress extends StandardEntity {
    private static final long serialVersionUID = 784505589915153906L;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @Column(name = "ADDRESS_LINE1", length = 100)
    private String addressLine1;

    @Column(name = "ADDRESS_LINE2", length = 100)
    private String addressLine2;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "PROVINCE", length = 100)
    private String province;

    @Column(name = "POSTAL_CODE", length = 25)
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
}