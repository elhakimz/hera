package org.hakeem.hera.listeners;

import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.entity.hr.EmploymentApplyStep;
import org.hakeem.hera.entity.types.EmploymentApplyStepType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Component("hera_EmploymentApplicationChangedListener")
public class EmploymentApplicationChangedListener {

    @Inject
    TransactionalDataManager dataManager;

}