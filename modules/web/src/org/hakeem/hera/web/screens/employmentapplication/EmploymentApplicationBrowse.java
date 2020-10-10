package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplication;

import javax.inject.Inject;

@UiController("hera_EmploymentApplication.browse")
@UiDescriptor("employment-application-browse.xml")
@LookupComponent("employmentApplicationsTable")
@LoadDataBeforeShow
public class EmploymentApplicationBrowse extends StandardLookup<EmploymentApplication> {

    @Inject
    private Button applicantBtn;

    @Subscribe("applicantBtn")
    public void onApplicantBtnClick(Button.ClickEvent event) {


    }
}