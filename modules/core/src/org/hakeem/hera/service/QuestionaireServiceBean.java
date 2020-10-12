package org.hakeem.hera.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.hakeem.hera.entity.common.Questionaire;
import org.hakeem.hera.entity.common.QuestionaireItem;
import org.hakeem.hera.entity.common.QuestionaireResult;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(QuestionaireService.NAME)
public class QuestionaireServiceBean implements QuestionaireService {


    @Inject
    protected DataManager dataManager;

    @Inject
    Persistence persistence;


    public static final String QUERY_QUESTIONAIRE="select e from hera_Questionaire e where e.questionaireType.name= :qtype";
    public static final String QUERY_ITEMS ="select e from hera_QuestionaireItem e where e.questionaire= :questionaire";


    public List<QuestionaireResult> generateQuestionaireList(String type){

        try(Transaction tx=persistence.createTransaction()){

            EntityManager em = persistence.getEntityManager();
            Questionaire questionaire=(Questionaire) em.createQuery(QUERY_QUESTIONAIRE)
                    .setParameter("qtype", type)
                    .getSingleResult();

            List<QuestionaireItem>  items = (List<QuestionaireItem>) em.createQuery(QUERY_ITEMS)
                    .setParameter("questionaire",questionaire)
                    .getResultList();

            List<QuestionaireResult> results = new ArrayList<>();
            for(QuestionaireItem qi:items){
                QuestionaireResult qr = dataManager.create(QuestionaireResult.class);
                qr.setId(UUID.randomUUID());
                qr.setQuestionaireItem(qi);
                qr.setOnDate(LocalDate.now());
                qr.setQuestionType(qi.getQuestionType());
                qr.setResult("");
                results.add(qr);
            }
            return results;
        }

    }
}