package org.hakeem.hera.web.screens.partyidentifier;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.PartyIdentifier;

@UiController("hera_PartyIdentifier.edit")
@UiDescriptor("party-identifier-edit.xml")
@EditedEntityContainer("partyIdentifierDc")
@LoadDataBeforeShow
public class PartyIdentifierEdit extends StandardEditor<PartyIdentifier> {
}