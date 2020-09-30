package org.hakeem.hera.web.screens.employee;

import com.haulmont.cuba.core.global.queryconditions.Condition;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Employee;
import org.hakeem.hera.entity.party.Party;
import org.hakeem.hera.entity.party.Person;
import org.hakeem.hera.web.screens.party.PartyPersonBrowse;
import org.hakeem.hera.web.screens.person.PersonFragment;

import javax.inject.Inject;
import java.util.Objects;

@UiController("hera_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private PickerField<Party> partyField;

    @Inject
    private InstanceContainer<Employee> employeeDc;

    @Inject
    private InstanceContainer<Person> personDc;
    @Inject
    private InstanceLoader<Person> personDl;


    @Subscribe("partyField.lookup")
    public void onPartyFieldLookup(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(partyField)
                .withScreenClass(PartyPersonBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .show();
    }

    @Subscribe("partyField")
    public void onPartyFieldValueChange(HasValue.ValueChangeEvent<Party> event) {
           personDl.setQuery("select p from hera_Person p where p.id = :id ");
           personDl.setParameter("id", Objects.requireNonNull(event.getValue()).getId());
           personDl.load();

    }


}