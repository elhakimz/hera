package org.hakeem.hera.web.screens.company;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Company;
import org.hakeem.hera.entity.party.Party;
import org.hakeem.hera.web.screens.party.PartyOrgBrowse;
import org.hakeem.hera.web.screens.party.PartyPersonBrowse;

import javax.inject.Inject;

@UiController("hera_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private PickerField<Party> partyField;

    @Subscribe("partyField.lookup")
    public void onPartyFieldLookup(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(partyField)
                .withScreenClass(PartyOrgBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .show();
    }
    
    
}