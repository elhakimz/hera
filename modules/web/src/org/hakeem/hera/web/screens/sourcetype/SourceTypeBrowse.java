package org.hakeem.hera.web.screens.sourcetype;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.types.SourceType;

@UiController("hera_SourceType.browse")
@UiDescriptor("source-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class SourceTypeBrowse extends MasterDetailScreen<SourceType> {
}