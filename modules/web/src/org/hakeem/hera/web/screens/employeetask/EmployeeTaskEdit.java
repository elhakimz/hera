package org.hakeem.hera.web.screens.employeetask;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.EmployeeTask;

@UiController("hera_EmployeeTask.edit")
@UiDescriptor("employee-task-edit.xml")
@EditedEntityContainer("employeeTaskDc")
@LoadDataBeforeShow
public class EmployeeTaskEdit extends StandardEditor<EmployeeTask> {
}