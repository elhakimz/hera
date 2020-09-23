package org.hakeem.hera.web.screens.positionclassificationtype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionClassificationType;

@UiController("hera_PositionClassificationType.browse")
@UiDescriptor("position-classification-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class PositionClassificationTypeBrowse extends MasterDetailScreen<PositionClassificationType> {
}