package org.hakeem.hera.web.screens.currency;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.finance.Currency;

@UiController("hera_Currency.browse")
@UiDescriptor("currency-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CurrencyBrowse extends MasterDetailScreen<Currency> {
}