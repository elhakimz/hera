package org.hakeem.hera.web.screens.communicationevent;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.CommunicationEvent;

@UiController("hera_CommunicationEvent.browse")
@UiDescriptor("communication-event-browse.xml")
@LookupComponent("communicationEventsTable")
@LoadDataBeforeShow
public class CommunicationEventBrowse extends StandardLookup<CommunicationEvent> {
}