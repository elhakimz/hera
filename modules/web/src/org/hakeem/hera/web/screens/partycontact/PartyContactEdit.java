package org.hakeem.hera.web.screens.partycontact;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyContact;

@UiController("hera_PartyContact.edit")
@UiDescriptor("party-contact-edit.xml")
@EditedEntityContainer("partyContactDc")
@LoadDataBeforeShow
public class PartyContactEdit extends StandardEditor<PartyContact> {
}