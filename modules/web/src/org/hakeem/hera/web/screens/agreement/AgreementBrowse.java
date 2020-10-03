package org.hakeem.hera.web.screens.agreement;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.agreement.Agreement;

@UiController("hera_Agreement.browse")
@UiDescriptor("agreement-browse.xml")
@LookupComponent("agreementsTable")
@LoadDataBeforeShow
public class AgreementBrowse extends StandardLookup<Agreement> {
}