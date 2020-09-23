package org.hakeem.hera.web.screens.party;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Party;

@UiController("hera_PartyPerson.browse")
@UiDescriptor("party-person-browse.xml")
@LookupComponent("partiesTable")
@LoadDataBeforeShow
public class PartyPersonBrowse extends StandardLookup<Party> {
}