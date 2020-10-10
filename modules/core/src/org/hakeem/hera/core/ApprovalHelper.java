package org.hakeem.hera.core;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TransactionalDataManager;
import org.hakeem.hera.entity.hr.EmploymentApplication;
import org.hakeem.hera.entity.hr.EmploymentApplyStep;
import org.hakeem.hera.entity.types.EmploymentApplyStepType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.UUID;

@Component(ApprovalHelper.NAME)
public class ApprovalHelper {
    public static final String NAME = "hera_ApprovalHelper";

    public static final String APPROVED = "Approved";

    @Inject
    protected TransactionalDataManager transactionalDataManager;


    @Inject
    private Persistence persistence;

    /**
     * update employment application state
     *
     * @param entityId entity id / uuid
     * @param state    state accepted from bpm
     * @param comment  comment from bpm
     */
    public void updateEmploymentApplicationState(UUID entityId, String state, String comment) {
        try (Transaction tx = persistence.getTransaction()) {

            EntityManager entityManager = persistence.getEntityManager();
            EmploymentApplication employmentApplication = entityManager.find(EmploymentApplication.class, entityId);

            if (employmentApplication != null) {
                employmentApplication.setProcessState(state);
                employmentApplication.setProcessDate(LocalDate.now());

                if (state.trim().equals(APPROVED)) {
                    EmploymentApplyStep step = new EmploymentApplyStep();
                    step.setId(UUID.randomUUID());
                    step.setStepDate(LocalDate.now());
                    step.setEmploymentApplyStepType(EmploymentApplyStepType.APPLICANT);
                    step.setDescription("Set to " + EmploymentApplyStepType.APPLICANT.getId() + " Comment:" + comment);
                    employmentApplication.setLastStep(EmploymentApplyStepType.APPLICANT.getId());
                    step.setEmploymentApplication(employmentApplication);
                    entityManager.merge(step);
                }
            }
            tx.commit();
        }
    }

    /**
     * update employee request state
     * @param entityId entity uuid
     * @param state bpm state
     * @param comment  bpm comment
     */
    public void updateEmployeeRequestState(UUID entityId, String state, String comment) {

        try (Transaction tx = persistence.getTransaction()) {


        }

    }
}