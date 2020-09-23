package org.hakeem.hera.web.screens.position;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Position;

@UiController("hera_Position.browse")
@UiDescriptor("position-browse.xml")
@LookupComponent("positionsTable")
@LoadDataBeforeShow
public class PositionBrowse extends StandardLookup<Position> {
}