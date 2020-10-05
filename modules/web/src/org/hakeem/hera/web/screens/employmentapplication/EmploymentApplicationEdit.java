package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplication;

@UiController("hera_EmploymentApplication.edit")
@UiDescriptor("employment-application-edit.xml")
@EditedEntityContainer("employmentApplicationDc")
@LoadDataBeforeShow
public class EmploymentApplicationEdit extends StandardEditor<EmploymentApplication> {
}