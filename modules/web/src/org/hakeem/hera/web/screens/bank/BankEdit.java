package org.hakeem.hera.web.screens.bank;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.finance.Bank;
import org.hakeem.hera.entity.finance.BankAccount;
import org.hakeem.hera.entity.finance.BankAccountNumber;

import javax.inject.Inject;
import java.util.UUID;

@UiController("hera_Bank.edit")
@UiDescriptor("bank-edit.xml")
@EditedEntityContainer("bankDc")
@LoadDataBeforeShow
public class BankEdit extends StandardEditor<Bank> {


    @Inject
    private DataContext dataContext;

    @Inject
    private Metadata metadata;
    @Inject
    private Table<BankAccount> bankAccountsTable;

    @Inject
    private CollectionLoader<BankAccountNumber> bankAccountNumbersDl;

    @Inject
    private Table<BankAccountNumber> bankAccountNumbersTable;

    private BankAccount currentBankAccount;
    @Inject
    private CollectionContainer<BankAccountNumber> bankAccountNumbersDc;

    @Subscribe("bankAccountsTable")
    public void onBankAccountsTableSelection(Table.SelectionEvent<BankAccount> event) {

        currentBankAccount = event.getSource().getSingleSelected();
          bankAccountNumbersDl.setQuery("select e from hera_BankAccountNumber e where e.bankAccount= :bankAccount");
          bankAccountNumbersDl.setParameter("bankAccount", currentBankAccount);
          bankAccountNumbersDl.load();
          bankAccountNumbersTable.setEnabled(true);
    }


    public void onCreateAccountNumber() {
         BankAccountNumber ban = dataContext.create(BankAccountNumber.class);
         ban.setBankAccount(currentBankAccount);
         ban.setAccountNo("?");
         ban.setIsActive(Boolean.FALSE);
         bankAccountNumbersDc.getMutableItems().add(ban);



    }

    @Subscribe("bankAccountNumbersTable.create")
    public void onBankAccountNumbersTableCreate(Action.ActionPerformedEvent event) {
       onCreateAccountNumber();
    }

    @Subscribe(id = "bankAccountNumbersDc", target = Target.DATA_CONTAINER)
    public void onBankAccountNumbersDcCollectionChange(CollectionContainer.CollectionChangeEvent<BankAccountNumber> event) {
        dataContext.commit();


    }
}