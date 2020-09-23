package org.hakeem.hera.web.screens.position;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Position;

@UiController("hera_Position.edit")
@UiDescriptor("position-edit.xml")
@EditedEntityContainer("positionDc")
@LoadDataBeforeShow
public class PositionEdit extends StandardEditor<Position> {
}