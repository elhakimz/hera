package org.hakeem.hera.web.screens.employmentapplystep;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplyStep;

@UiController("hera_EmploymentApplStep.edit")
@UiDescriptor("employment-apply-step-edit.xml")
@EditedEntityContainer("employmentApplyStepDc")
@LoadDataBeforeShow
public class EmploymentApplyStepEdit extends StandardEditor<EmploymentApplyStep> {
}