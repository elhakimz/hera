package org.hakeem.hera.web.screens.communicationeventpurpose;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.CommunicationEventPurpose;

@UiController("hera_CommunicationEventPurpose.edit")
@UiDescriptor("communication-event-purpose-edit.xml")
@EditedEntityContainer("communicationEventPurposeDc")
@LoadDataBeforeShow
public class CommunicationEventPurposeEdit extends StandardEditor<CommunicationEventPurpose> {
}