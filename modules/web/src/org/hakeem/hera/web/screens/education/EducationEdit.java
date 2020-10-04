package org.hakeem.hera.web.screens.education;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.qualification.Education;

@UiController("hera_Education.edit")
@UiDescriptor("education-edit.xml")
@EditedEntityContainer("educationDc")
@LoadDataBeforeShow
public class EducationEdit extends StandardEditor<Education> {
}