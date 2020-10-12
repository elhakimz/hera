package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.web.screens.person.PersonApplicantEdit;

import javax.inject.Inject;

@UiController("hera_EmploymentApplication.browse")
@UiDescriptor("employment-application-browse.xml")
@LookupComponent("employmentApplicationsTable")
@LoadDataBeforeShow
public class EmploymentApplicationBrowse extends StandardLookup<EmploymentApplication> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Button applicantBtn;
    @Inject
    private CollectionContainer<EmploymentApplication> employmentApplicationsDc;
    @Inject
    private CollectionLoader<EmploymentApplication> employmentApplicationsDl;

    @Subscribe("applicantBtn")
    public void onApplicantBtnClick(Button.ClickEvent event) {
        screenBuilders.screen(this)
                .withScreenClass(PersonApplicantEdit.class)
                .withAfterCloseListener(e-> reloadData())
                .withLaunchMode(OpenMode.THIS_TAB)
                .build()
                .show();
    }

    private void reloadData(){
        employmentApplicationsDl.load();
    }

}