package org.hakeem.hera.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Company;

@UiController("hera_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companiesTable")
@LoadDataBeforeShow
public class CompanyBrowse extends StandardLookup<Company> {
}