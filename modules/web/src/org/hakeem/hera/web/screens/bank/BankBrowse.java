package org.hakeem.hera.web.screens.bank;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.finance.Bank;

@UiController("hera_Bank.browse")
@UiDescriptor("bank-browse.xml")
@LookupComponent("banksTable")
@LoadDataBeforeShow
public class BankBrowse extends StandardLookup<Bank> {
}