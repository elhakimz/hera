package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.bpm.entity.ProcAttachment;
import com.haulmont.bpm.gui.procactionsfragment.ProcActionsFragment;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmploymentApplication;

import javax.inject.Inject;

@UiController("hera_EmploymentApplication.edit")
@UiDescriptor("employment-application-edit.xml")
@EditedEntityContainer("employmentApplicationDc")
@LoadDataBeforeShow
public class EmploymentApplicationEdit extends StandardEditor<EmploymentApplication> {

    private static final String PROCESS_CODE = "employmentApplicationApproval";


    @Inject
    private InstanceContainer<EmploymentApplication> employmentApplicationDc;


    @Inject
    private CollectionContainer<ProcAttachment> procAttachmentsDc;


    @Inject
    private Table<ProcAttachment> attachmentsTable;


    @Inject
    private InstanceLoader<EmploymentApplication> employmentApplicationDl;
    @Inject
    private CollectionLoader<ProcAttachment> procAttachmentsDl;
    @Inject
    private ProcActionsFragment procActionsFragment;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        employmentApplicationDl.load();
        procAttachmentsDl.setParameter("entityId",employmentApplicationDc.getItem().getId());
        procAttachmentsDl.load();

        procActionsFragment.initializer()
                .standard()
                .init(PROCESS_CODE, getEditedEntity());

        FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");
    }


}