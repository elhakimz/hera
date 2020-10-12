package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Entity;

@javax.persistence.DiscriminatorValue("QUESTIONAIRETYPE")
@Entity(name = "hera_QuestionaireType")
@NamePattern("%s|name")
public class QuestionaireType extends NameDescription {
    private static final long serialVersionUID = 9218056378599431162L;

}