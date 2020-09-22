package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "HERA_PARTY")
@Entity(name = "hera_Party")
@NamePattern("%s|name")
public class Party extends StandardEntity {
    private static final long serialVersionUID = -705611384233901522L;

    @Column(name = "NAME", length = 100)
    private String name;

    @OneToMany(mappedBy = "party")
    private List<PartyAddress> addresses;

    public List<PartyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PartyAddress> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}