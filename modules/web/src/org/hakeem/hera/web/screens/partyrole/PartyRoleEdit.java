package org.hakeem.hera.web.screens.partyrole;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyRole;

@UiController("hera_PartyRole.edit")
@UiDescriptor("party-role-edit.xml")
@EditedEntityContainer("partyRoleDc")
@LoadDataBeforeShow
public class PartyRoleEdit extends StandardEditor<PartyRole> {
}