package org.hakeem.hera.web.screens.positiontypeclass;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionTypeClass;

@UiController("hera_PositionTypeClass.edit")
@UiDescriptor("position-type-class-edit.xml")
@EditedEntityContainer("positionTypeClassDc")
@LoadDataBeforeShow
public class PositionTypeClassEdit extends StandardEditor<PositionTypeClass> {
}