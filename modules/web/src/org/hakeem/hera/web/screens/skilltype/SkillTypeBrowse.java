package org.hakeem.hera.web.screens.skilltype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.qualification.SkillType;

@UiController("hera_SkillType.browse")
@UiDescriptor("skill-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class SkillTypeBrowse extends MasterDetailScreen<SkillType> {
}