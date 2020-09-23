package org.hakeem.hera.web.screens.partyaddress;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyAddress;

@UiController("hera_PartyAddress.edit")
@UiDescriptor("party-address-edit.xml")
@EditedEntityContainer("partyAddressDc")
@LoadDataBeforeShow
public class PartyAddressEdit extends StandardEditor<PartyAddress> {
}