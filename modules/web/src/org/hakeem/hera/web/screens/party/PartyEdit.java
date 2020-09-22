package org.hakeem.hera.web.screens.party;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Party;

@UiController("hera_Party.edit")
@UiDescriptor("party-edit.xml")
@EditedEntityContainer("partyDc")
@LoadDataBeforeShow
public class PartyEdit extends StandardEditor<Party> {
}