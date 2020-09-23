package org.hakeem.hera.web.screens.positionfulfillment;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionFulfillment;

@UiController("hera_PositionFulfillment.edit")
@UiDescriptor("position-fulfillment-edit.xml")
@EditedEntityContainer("positionFulfillmentDc")
@LoadDataBeforeShow
public class PositionFulfillmentEdit extends StandardEditor<PositionFulfillment> {
}