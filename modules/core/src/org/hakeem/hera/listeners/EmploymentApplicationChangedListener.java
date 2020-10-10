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

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<EmploymentApplication, UUID> event) {
        EmploymentApplication employmentApplication = dataManager.getReference(EmploymentApplication.class, event.getEntityId().getValue());
        createStepLine(employmentApplication);
        dataManager.save(employmentApplication);
    }

    private void createStepLine(EmploymentApplication employmentApplication){
        if(employmentApplication.getSteps()==null){
            employmentApplication.setSteps(new ArrayList<>());
        }

        if(employmentApplication.getSteps().isEmpty()){
            EmploymentApplyStep eas = dataManager.create(EmploymentApplyStep.class);
            eas.setId(UUID.randomUUID());
            eas.setStepDate(LocalDate.now());
            eas.setEmploymentApplyStepType(EmploymentApplyStepType.SOURCED);
            eas.setDescription(EmploymentApplyStepType.SOURCED.getId());
            eas.setEmploymentApplication(employmentApplication);
            employmentApplication.getSteps().add(eas);
            dataManager.save(eas);
        }
    }
}