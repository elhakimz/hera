package org.hakeem.hera.service;

import org.hakeem.hera.entity.common.QuestionaireResult;

import java.util.List;

public interface QuestionaireService {
    String NAME = "hera_QuestionaireService";

    List<QuestionaireResult> generateQuestionaireList(String type);
}