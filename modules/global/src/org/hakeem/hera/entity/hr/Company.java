package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.party.PartyRole;
import org.slf4j.Logger;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

@javax.persistence.DiscriminatorValue("COMPANY")
@Entity(name = "hera_Company")
@NamePattern("%s|name")
public class Company extends PartyRole {
    private static final long serialVersionUID = -3310721788063181548L;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Company.class);
    @PrePersist
    public void prePersist() {
        try {
            if(getParty()!=null && (getName()==null || getName().isEmpty())){
                setName(getParty().getName());
                setDescription(getParty().getName()+",Company");
            }
        } catch (Exception e) {
            log.error("Error", e);
        }

    }
}