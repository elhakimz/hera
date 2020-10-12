package org.hakeem.hera.web.screens.questionaireitem;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.common.QuestionaireItem;

@UiController("hera_QuestionaireItem.edit")
@UiDescriptor("questionaire-item-edit.xml")
@EditedEntityContainer("questionaireItemDc")
@LoadDataBeforeShow
public class QuestionaireItemEdit extends StandardEditor<QuestionaireItem> {
}