package org.hakeem.hera.web.screens.communicationevent;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.CommunicationEvent;

@UiController("hera_CommunicationEvent.edit")
@UiDescriptor("communication-event-edit.xml")
@EditedEntityContainer("communicationEventDc")
@LoadDataBeforeShow
public class CommunicationEventEdit extends StandardEditor<CommunicationEvent> {
}