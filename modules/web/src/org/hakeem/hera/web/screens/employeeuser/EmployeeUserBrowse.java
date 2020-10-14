package org.hakeem.hera.web.screens.employeeuser;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmployeeUser;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.UUID;

@UiController("hera_EmployeeUser.browse")
@UiDescriptor("employee-user-browse.xml")
@LookupComponent("employeeUsersTable")
@LoadDataBeforeShow
public class EmployeeUserBrowse extends StandardLookup<EmployeeUser> {
    @Inject
    protected DataGrid<EmployeeUser> employeeUsersTable;


    @Inject
    protected CollectionContainer<EmployeeUser> employeeUsersDc;
    @Inject
    protected DataManager dataManager;
    @Inject
    protected DataContext dataContext;

    @Subscribe("employeeUsersTable.create")
    protected void onEmployeeUsersTableCreate(Action.ActionPerformedEvent event) {

        EmployeeUser employeeUser = dataContext.create(EmployeeUser.class);
        employeeUser.setId(UUID.randomUUID());
        employeeUser.setRegisterDate(LocalDate.now());
        employeeUsersDc.getMutableItems().add(employeeUser);
        dataContext.commit();
        employeeUsersTable.setSelected(employeeUser);
    }


}