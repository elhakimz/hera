package org.hakeem.hera.web.screens.positionresponsibility;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.PositionResponsibility;

@UiController("hera_PositionResponsibility.edit")
@UiDescriptor("position-responsibility-edit.xml")
@EditedEntityContainer("positionResponsibilityDc")
@LoadDataBeforeShow
public class PositionResponsibilityEdit extends StandardEditor<PositionResponsibility> {
}