package org.hakeem.hera.web.screens.partyrole;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRole;

@UiController("hera_PartyCompany.browse")
@UiDescriptor("party-company-browse.xml")
@LookupComponent("partyRolesTable")
@LoadDataBeforeShow
public class PartyCompanyBrowse extends StandardLookup<PartyRole> {
}