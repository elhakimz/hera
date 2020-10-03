package org.hakeem.hera.web.screens.agreement;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.agreement.Agreement;

@UiController("hera_Agreement.edit")
@UiDescriptor("agreement-edit.xml")
@EditedEntityContainer("agreementDc")
@LoadDataBeforeShow
public class AgreementEdit extends StandardEditor<Agreement> {
}