package org.hakeem.hera.web.screens.communicationeventpurposetype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.CommunicationEventPurposeType;

@UiController("hera_CommunicationEventPurposeType.browse")
@UiDescriptor("communication-event-purpose-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CommunicationEventPurposeTypeBrowse extends MasterDetailScreen<CommunicationEventPurposeType> {
}