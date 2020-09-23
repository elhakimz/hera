package org.hakeem.hera.web.screens.partyrole;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRole;

@UiController("hera_PartyEmployee.browse")
@UiDescriptor("party-employee-browse.xml")
@LookupComponent("partyRolesTable")
@LoadDataBeforeShow
public class PartyEmployeeBrowse extends StandardLookup<PartyRole> {
}