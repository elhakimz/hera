package org.hakeem.hera.web.screens.person

import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.CheckBox
import com.haulmont.cuba.gui.components.CurrencyField
import com.haulmont.cuba.gui.components.LookupField
import com.haulmont.cuba.gui.components.TextArea
import com.haulmont.cuba.gui.components.TextField
import com.haulmont.cuba.gui.model.InstanceContainer
import com.haulmont.cuba.gui.screen.*
import org.hakeem.hera.entity.party.Person

import javax.inject.Inject

@UiController("hera_PersonApplicant.edit")
@UiDescriptor("person-applicant-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
class PersonApplicantEdit extends StandardEditor<Person> {

    @Inject
    DataManager dataManager;

    @Inject
    InstanceContainer<Person> personDc

    @Inject
    LookupField positionWantedField

    @Inject
    CurrencyField<BigDecimal> salaryWantedField

    @Inject
    TextField<String> facilityWantedField

    @Inject
    CheckBox probationField

    @Inject
    TextArea<String> reasonField

    @Inject
    TextArea<String> visionField

    @Subscribe("btnCommitAndClose")
    void onBtnCommitAndCloseClick(Button.ClickEvent event) {
          //save the person and employee application
          saveEmployeeApplication();
    }

    private void saveEmployeeApplication(){

    }



}