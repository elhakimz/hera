package org.hakeem.hera.web.screens.employment;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.Employment;
import org.hakeem.hera.entity.party.PartyRole;
import org.hakeem.hera.web.screens.party.PartyPersonBrowse;
import org.hakeem.hera.web.screens.partyrole.PartyCompanyBrowse;
import org.hakeem.hera.web.screens.partyrole.PartyEmployeeBrowse;

import javax.inject.Inject;

@UiController("hera_Employment.edit")
@UiDescriptor("employment-edit.xml")
@EditedEntityContainer("employmentDc")
@LoadDataBeforeShow
public class EmploymentEdit extends StandardEditor<Employment> {


    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private PickerField<PartyRole> fromPartyRoleField;

    @Inject
    private PickerField<PartyRole> toPartyRoleField;

    @Subscribe("fromPartyRoleField.lookup")
    public void onFromPartyRoleFieldLookup(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(fromPartyRoleField)
                .withScreenClass(PartyEmployeeBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .show();
    }

    @Subscribe("toPartyRoleField.lookup")
    public void onToPartyRoleFieldLookup(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(toPartyRoleField)
                .withScreenClass(PartyCompanyBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .show();
    }
}