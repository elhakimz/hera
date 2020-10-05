package org.hakeem.hera.web.screens.partyrelationship;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRelationship;

@UiController("hera_PartyRelationship.browse")
@UiDescriptor("party-relationship-browse.xml")
@LookupComponent("partyRelationshipsTable")
@LoadDataBeforeShow
public class PartyRelationshipBrowse extends StandardLookup<PartyRelationship> {
}