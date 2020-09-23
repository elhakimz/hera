package org.hakeem.hera.web.screens.positiontype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionType;

@UiController("hera_PositionType.browse")
@UiDescriptor("position-type-browse.xml")
@LookupComponent("positionTypesTable")
@LoadDataBeforeShow
public class PositionTypeBrowse extends StandardLookup<PositionType> {
}