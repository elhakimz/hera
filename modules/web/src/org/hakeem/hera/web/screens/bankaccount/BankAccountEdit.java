package org.hakeem.hera.web.screens.bankaccount;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.finance.BankAccount;

@UiController("hera_BankAccount.edit")
@UiDescriptor("bank-account-edit.xml")
@EditedEntityContainer("bankAccountDc")
@LoadDataBeforeShow
public class BankAccountEdit extends StandardEditor<BankAccount> {
}