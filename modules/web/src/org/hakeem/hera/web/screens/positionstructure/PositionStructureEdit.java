package org.hakeem.hera.web.screens.positionstructure;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionStructure;

@UiController("hera_PositionStructure.edit")
@UiDescriptor("position-structure-edit.xml")
@EditedEntityContainer("positionStructureDc")
@LoadDataBeforeShow
public class PositionStructureEdit extends StandardEditor<PositionStructure> {
}