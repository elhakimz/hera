package org.hakeem.hera.entity.hr;

import org.hakeem.hera.entity.party.PartyRole;

import javax.persistence.Entity;

@javax.persistence.DiscriminatorValue("COMPANY")
@Entity(name = "hera_Company")
public class Company extends PartyRole {
    private static final long serialVersionUID = -3310721788063181548L;
}