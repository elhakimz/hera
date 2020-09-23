package org.hakeem.hera.web.screens.partyrole;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRole;

@UiController("hera_PartyRole.browse")
@UiDescriptor("party-role-browse.xml")
@LookupComponent("partyRolesTable")
@LoadDataBeforeShow
public class PartyRoleBrowse extends StandardLookup<PartyRole> {
}