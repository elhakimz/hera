package org.hakeem.hera.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.hakeem.hera.entity.party.PartyAddress;
import org.hakeem.hera.entity.party.PartyRole;
import org.hakeem.hera.entity.party.PartyRoleType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;

@Service(PartyService.NAME)
public class PartyServiceBean implements PartyService {


    @Inject
    protected Persistence persistence;

    @Inject
    protected DataManager dataManager;

    /**
     * create party role by roletype name
     * @param roleTypeName
     * @return
     */
    public PartyRole createPartyRole(String roleTypeName){

        final String query = "select e from hera_PartyRoleType e where e.name= :name";
        try(Transaction tx=persistence.createTransaction()){
            EntityManager em = persistence.getEntityManager();

            PartyRoleType prt = em.createQuery(query, PartyRoleType.class)
               .setParameter("name", roleTypeName).getFirstResult();

            if(prt!=null){
                PartyRole pr = dataManager.create(PartyRole.class);
                pr.setPartyRoleType(prt);
                pr.setFromDate(LocalDate.now());
                em.flush();
                return pr;
            }else{
                return null;
            }

        }
    }



    @Override
    public PartyAddress createPartyAddress(String street, String country) {
        return null;
    }

}