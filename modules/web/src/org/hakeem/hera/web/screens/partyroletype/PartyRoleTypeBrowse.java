package org.hakeem.hera.web.screens.partyroletype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRoleType;

@UiController("hera_PartyRoleType.browse")
@UiDescriptor("party-role-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class PartyRoleTypeBrowse extends MasterDetailScreen<PartyRoleType> {
}