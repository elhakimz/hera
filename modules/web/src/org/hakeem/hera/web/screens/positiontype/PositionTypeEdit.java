package org.hakeem.hera.web.screens.positiontype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionType;

@UiController("hera_PositionType.edit")
@UiDescriptor("position-type-edit.xml")
@EditedEntityContainer("positionTypeDc")
@LoadDataBeforeShow
public class PositionTypeEdit extends StandardEditor<PositionType> {
}