package org.hakeem.hera.web.screens.partyaddress;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyAddress;

@UiController("hera_PartyAddress.browse")
@UiDescriptor("party-address-browse.xml")
@LookupComponent("partyAddressesTable")
@LoadDataBeforeShow
public class PartyAddressBrowse extends StandardLookup<PartyAddress> {
}