package org.hakeem.hera.web.screens.questionaire;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.Questionaire;

@UiController("hera_Questionaire.edit")
@UiDescriptor("questionaire-edit.xml")
@EditedEntityContainer("questionaireDc")
@LoadDataBeforeShow
public class QuestionaireEdit extends StandardEditor<Questionaire> {
}