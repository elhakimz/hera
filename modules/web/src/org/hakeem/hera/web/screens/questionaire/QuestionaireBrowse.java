package org.hakeem.hera.web.screens.questionaire;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.Questionaire;

@UiController("hera_Questionaire.browse")
@UiDescriptor("questionaire-browse.xml")
@LookupComponent("questionairesTable")
@LoadDataBeforeShow
public class QuestionaireBrowse extends StandardLookup<Questionaire> {
}