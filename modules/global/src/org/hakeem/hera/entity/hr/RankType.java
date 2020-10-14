package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.common.NameDescription;

import javax.persistence.Column;
import javax.persistence.Entity;

@javax.persistence.DiscriminatorValue("RANKTYPE")
@Entity(name = "hera_Rank")
@NamePattern("%s|name")
public class RankType extends NameDescription {
    private static final long serialVersionUID = 4987649209323041845L;


}