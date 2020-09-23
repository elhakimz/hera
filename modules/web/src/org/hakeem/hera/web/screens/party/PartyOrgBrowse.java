package org.hakeem.hera.web.screens.party;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Party;

@UiController("hera_PartyOrg.browse")
@UiDescriptor("party-org-browse.xml")
@LookupComponent("partiesTable")
@LoadDataBeforeShow
public class PartyOrgBrowse extends StandardLookup<Party> {
}