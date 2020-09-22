package org.hakeem.hera.web.screens.country;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.types.Country;

@UiController("hera_Country.browse")
@UiDescriptor("country-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CountryBrowse extends MasterDetailScreen<Country> {
}