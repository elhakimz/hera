package org.hakeem.hera.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Person;

@UiController("hera_Person.edit")
@UiDescriptor("person-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonEdit extends StandardEditor<Person> {
}