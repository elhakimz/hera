package org.hakeem.hera.web.screens.employment;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Employment;

@UiController("hera_Employment.browse")
@UiDescriptor("employment-browse.xml")
@LookupComponent("employmentsTable")
@LoadDataBeforeShow
public class EmploymentBrowse extends StandardLookup<Employment> {
}