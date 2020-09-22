package org.hakeem.hera.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Person;

@UiController("hera_Person.browse")
@UiDescriptor("person-browse.xml")
@LookupComponent("personsTable")
@LoadDataBeforeShow
public class PersonBrowse extends StandardLookup<Person> {
}