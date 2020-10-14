package org.hakeem.hera.web.screens.employmentapplication;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.web.screens.person.PersonApplicantEdit;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("hera_EmploymentApplication.browse")
@UiDescriptor("employment-application-browse.xml")
@LookupComponent("employmentApplicationsTable")
@LoadDataBeforeShow
public class EmploymentApplicationBrowse extends StandardLookup<EmploymentApplication> {

    @Inject
    protected LookupField lookUpPropagate;
    @Inject
    protected Button propagateBtn;
    @Inject
    protected GroupTable<EmploymentApplication> employmentApplicationsTable;
    @Inject
    protected Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Button applicantBtn;

    @Inject
    private CollectionContainer<EmploymentApplication> employmentApplicationsDc;
    @Inject
    private CollectionLoader<EmploymentApplication> employmentApplicationsDl;

    @Subscribe
    protected void onInit(InitEvent event) {
        Map<String,String> map = new HashMap<>();
        map.put("Disetujui","APPROVED");
        map.put("Kandidat","CANDIDATE");
        map.put("Wawancara","INTERVIEW");
        map.put("Tawaran","OFFERED");
        map.put("Direkrut","EMPLOYED");
        lookUpPropagate.setOptionsMap(map);
    }

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


    @Subscribe("employmentApplicationsTable")
    protected void onEmploymentApplicationsTableSelection(Table.SelectionEvent<EmploymentApplication> event) {
        if(event.getSource().getSingleSelected()==null){
            lookUpPropagate.setEnabled(false);
            propagateBtn.setEnabled(false);
        }else{
            lookUpPropagate.setEnabled(true);
            propagateBtn.setEnabled(true);
        }
    }

    @Subscribe("propagateBtn")
    protected void onPropagateBtnClick(Button.ClickEvent event) {
        EmploymentApplication ea = employmentApplicationsTable.getSingleSelected();
        if(ea==null) return;
        String currentState = ea.getProcessState()==null ? "" : ea.getProcessState();
        String selectedProp = String.valueOf(lookUpPropagate.getValue());
        if(currentState.isEmpty() && selectedProp.equals("APPROVED")){
            //set status = APPROVED

        } else if (currentState.equals("APPROVED") && selectedProp.equals("CANDIDATE")) {
           //request status = CANDIDATE

        } else if (currentState.equals("CANDIDATE") && selectedProp.equals("INTERVIEW")){
           //request status = INTERVIEW

        }else if (currentState.equals("INTERVIEW") && selectedProp.equals("OFFERED")){
           //request status= OFFERED

        }else if (currentState.equals("OFFERED") && selectedProp.equals("EMPLOYED")){
            //request status = EMPLOYED

        }else {
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Invalid State")
                    .withDescription("Usulan "+lookUpPropagate.getDescription()+" ditolak")
                    .show();
        }

    }

}