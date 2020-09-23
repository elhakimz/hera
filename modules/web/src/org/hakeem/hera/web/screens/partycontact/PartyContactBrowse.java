package org.hakeem.hera.web.screens.partycontact;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyContact;

@UiController("hera_PartyContact.browse")
@UiDescriptor("party-contact-browse.xml")
@LookupComponent("partyContactsTable")
@LoadDataBeforeShow
public class PartyContactBrowse extends StandardLookup<PartyContact> {
}