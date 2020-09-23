package org.hakeem.hera.entity.hr;

import org.hakeem.hera.entity.party.PartyRelationship;
import org.slf4j.Logger;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

@javax.persistence.DiscriminatorValue("EMPLOYMENT")
@Entity(name = "hera_Employment")
public class Employment extends PartyRelationship {
    private static final long serialVersionUID = -7219017495740430382L;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Employment.class);


    @PrePersist
    public void prePersist() {
         setName("Employment");
         String s1="?";
         String s2="?";
        try {
            if(getFromPartyRole()!=null) s1 = getFromPartyRole().getName();
            if(getToPartyRole()!=null) s2 = getToPartyRole().getName();
            setDescription("Employment of "+s1+" by "+s2);
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}