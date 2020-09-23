package org.hakeem.hera.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Organization;

@UiController("hera_Organization.edit")
@UiDescriptor("organization-edit.xml")
@EditedEntityContainer("organizationDc")
@LoadDataBeforeShow
public class OrganizationEdit extends StandardEditor<Organization> {
}