package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@javax.persistence.DiscriminatorValue("QUESTIONAIRETYPE")
@Table(name = "HERA_QUESTIONAIRE_TYPE")
@Entity(name = "hera_QuestionaireType")
@NamePattern("%s|name")
public class QuestionaireType extends NameDescription {
    private static final long serialVersionUID = 9218056378599431162L;
}