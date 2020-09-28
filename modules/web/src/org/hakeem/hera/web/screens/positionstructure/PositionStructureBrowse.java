package org.hakeem.hera.web.screens.positionstructure;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionStructure;

@UiController("hera_PositionStructure.browse")
@UiDescriptor("position-structure-browse.xml")
@LookupComponent("positionStructuresTable")
@LoadDataBeforeShow
public class PositionStructureBrowse extends StandardLookup<PositionStructure> {
}