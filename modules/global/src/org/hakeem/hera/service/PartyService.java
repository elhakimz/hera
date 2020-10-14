package org.hakeem.hera.service;

import org.hakeem.hera.entity.party.PartyAddress;
import org.hakeem.hera.entity.party.PartyRole;

public interface PartyService {
    String NAME = "hera_PartyService";

    PartyRole createPartyRole(String roleTypeName);

    PartyAddress createPartyAddress(String street, String country);

}