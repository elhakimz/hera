package org.hakeem.hera.core;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import org.hakeem.hera.entity.common.Questionaire;
import org.hakeem.hera.entity.common.QuestionaireItem;
import org.hakeem.hera.entity.common.QuestionaireResult;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component(QuestionHelperBean.NAME)
public class QuestionHelperBean {
    public static final String NAME = "hera_QuestionHelperBean";

}