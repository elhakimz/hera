package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplication;

@UiController("hera_EmploymentApplication.browse")
@UiDescriptor("employment-application-browse.xml")
@LookupComponent("employmentApplicationsTable")
@LoadDataBeforeShow
public class EmploymentApplicationBrowse extends StandardLookup<EmploymentApplication> {
}