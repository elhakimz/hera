package org.hakeem.hera.web.screens.party;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Party;

@UiController("hera_Party.browse")
@UiDescriptor("party-browse.xml")
@LookupComponent("partiesTable")
@LoadDataBeforeShow
public class PartyBrowse extends StandardLookup<Party> {
}