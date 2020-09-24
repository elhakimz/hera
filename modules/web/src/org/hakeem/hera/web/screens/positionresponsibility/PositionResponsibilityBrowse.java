package org.hakeem.hera.web.screens.positionresponsibility;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionResponsibility;

@UiController("hera_PositionResponsibility.browse")
@UiDescriptor("position-responsibility-browse.xml")
@LookupComponent("positionResponsibilitiesTable")
@LoadDataBeforeShow
public class PositionResponsibilityBrowse extends StandardLookup<PositionResponsibility> {
}