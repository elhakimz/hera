package org.hakeem.hera.listeners;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import org.hakeem.hera.entity.hr.Employee;
import org.hakeem.hera.entity.party.PartyRoleType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("hera_EmployeeChangedListener")
public class EmployeeChangedListener {

    @Inject
    protected Persistence persistence;

    @Inject
    protected TransactionalDataManager tdm;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<Employee, UUID> event) {

        Employee employee= tdm.load(event.getEntityId()).view("employee-view").one();
        if(employee.getPartyRoleType()==null){
                EntityManager em= persistence.getEntityManager();
                PartyRoleType prt = em.createQuery("select e from  hera_PartyRoleType e where e.name= :name",PartyRoleType.class)
                        .setParameter("name","EMPLOYEE").getSingleResult();
                employee.setPartyRoleType(prt);
                tdm.save(employee);


        }
    }

}