package org.hakeem.hera.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.party.Organization;

@UiController("hera_Organization.browse")
@UiDescriptor("organization-browse.xml")
@LookupComponent("organizationsTable")
@LoadDataBeforeShow
public class OrganizationBrowse extends StandardLookup<Organization> {
}