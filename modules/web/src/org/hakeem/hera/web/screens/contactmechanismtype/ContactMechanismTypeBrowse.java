package org.hakeem.hera.web.screens.contactmechanismtype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.commevent.ContactMechanismType;

@UiController("hera_ContactMechanismType.browse")
@UiDescriptor("contact-mechanism-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ContactMechanismTypeBrowse extends MasterDetailScreen<ContactMechanismType> {
}