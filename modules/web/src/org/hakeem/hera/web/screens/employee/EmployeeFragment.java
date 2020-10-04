package org.hakeem.hera.web.screens.employee;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.hakeem.hera.entity.hr.Employee;

import javax.inject.Inject;

@UiController("hera_EmployeeFragment")
@UiDescriptor("employee-fragment.xml")
public class EmployeeFragment extends ScreenFragment {

    @Inject
    private InstanceContainer<Employee> employeeDc;

}