package org.hakeem.hera.entity.hr;

import org.hakeem.hera.entity.party.PartyRelationship;

import javax.persistence.Entity;

@javax.persistence.DiscriminatorValue("EMPLOYMENT")
@Entity(name = "hera_Employment")
public class Employment extends PartyRelationship {
    private static final long serialVersionUID = -7219017495740430382L;

}