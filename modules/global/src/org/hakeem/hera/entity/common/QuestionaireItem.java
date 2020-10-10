package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "HERA_QUESTIONAIRE_ITEM")
@Entity(name = "hera_QuestionaireItem")
@NamePattern("%s|question")
public class QuestionaireItem extends StandardEntity {
    private static final long serialVersionUID = -3449610704793969574L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTIONAIRE_ID")
    private Questionaire questionaire;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "LANG_CODE", length = 10)
    private String langCode;

    @Column(name = "ANSWER")
    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestionaire(Questionaire questionaire) {
        this.questionaire = questionaire;
    }

    public Questionaire getQuestionaire() {
        return questionaire;
    }

}