package org.hakeem.hera.listeners;

import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.hakeem.hera.entity.finance.Bank;
import org.hakeem.hera.entity.party.Organization;
import org.hakeem.hera.entity.party.PartyRole;
import org.hakeem.hera.service.PartyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("hera_BankChangedListener")
public class BankChangedListener {

    @Inject
    protected PartyService partyService;

    @Inject
    TransactionalDataManager tdm;


    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<Bank, UUID> event) {

        Bank bank= tdm.load(event.getEntityId()).view("bank-view").one();
        Organization organization = bank.getOrganization();

        PartyRole role =partyService.createPartyRole("BANK");
        role.setParty(organization);
        role.setFromDate(LocalDate.now());

        if(organization.getPartyRoles()==null){
           List<PartyRole> roleList = new ArrayList<>();
           organization.setPartyRoles(roleList);
        }

        organization.getPartyRoles().add(role);
        tdm.save(organization);

    }
}