package org.hakeem.hera.web.screens.skill;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.qualification.Skill;

@UiController("hera_Skill.edit")
@UiDescriptor("skill-edit.xml")
@EditedEntityContainer("skillDc")
@LoadDataBeforeShow
public class SkillEdit extends StandardEditor<Skill> {
}