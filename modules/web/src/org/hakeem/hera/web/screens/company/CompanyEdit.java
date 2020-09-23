package org.hakeem.hera.web.screens.company;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Company;
import org.hakeem.hera.entity.party.Party;

import javax.inject.Inject;

@UiController("hera_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
    @Inject
    private PickerField<Party> partyField;

    @Subscribe("partyField.lookup")
    public void onPartyFieldLookup(Action.ActionPerformedEvent event) {
        
    }
    
    
}