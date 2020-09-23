package org.hakeem.hera.web.screens.partyidentifier;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyIdentifier;

@UiController("hera_PartyIdentifier.browse")
@UiDescriptor("party-identifier-browse.xml")
@LookupComponent("partyIdentifiersTable")
@LoadDataBeforeShow
public class PartyIdentifierBrowse extends StandardLookup<PartyIdentifier> {
}