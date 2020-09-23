package org.hakeem.hera.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Employee;

@UiController("hera_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}