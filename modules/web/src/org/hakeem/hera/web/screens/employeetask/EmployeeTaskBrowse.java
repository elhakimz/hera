package org.hakeem.hera.web.screens.employeetask;

import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Employee;
import org.hakeem.hera.entity.hr.EmployeeTask;

import javax.inject.Inject;

@UiController("hera_EmployeeTask.browse")
@UiDescriptor("employee-task-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeTaskBrowse extends StandardLookup<EmployeeTask> {

    @Inject
    protected CollectionContainer<EmployeeTask> employeeTasksDc;

    @Inject
    protected CollectionLoader<EmployeeTask> employeeTasksDl;


    @Inject
    protected CollectionLoader<Employee> employeedDl;


    @Inject
    protected Table<Employee> employeesTable;

}