package org.hakeem.hera.web.screens.communicationeventpurpose;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.CommunicationEventPurpose;

@UiController("hera_CommunicationEventPurpose.browse")
@UiDescriptor("communication-event-purpose-browse.xml")
@LookupComponent("communicationEventPurposesTable")
@LoadDataBeforeShow
public class CommunicationEventPurposeBrowse extends StandardLookup<CommunicationEventPurpose> {
}