package org.hakeem.hera.web.screens.positionfulfillment;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionFulfillment;

@UiController("hera_PositionFulfillment.browse")
@UiDescriptor("position-fulfillment-browse.xml")
@LookupComponent("positionFulfillmentsTable")
@LoadDataBeforeShow
public class PositionFulfillmentBrowse extends StandardLookup<PositionFulfillment> {
}