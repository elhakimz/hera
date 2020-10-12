package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.types.FamilyRelationType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("FAMILYRELATION")
@Entity(name = "hera_FamilyRelation")
@NamePattern("%s|name")
public class FamilyRelation extends PartyRelationship {
    private static final long serialVersionUID = 3389285998871397311L;

    @Column(name = "FAMILY_RELATION_TYPE")
    private String familyRelationType;

    public FamilyRelationType getFamilyRelationType() {
        return familyRelationType == null ? null : FamilyRelationType.fromId(familyRelationType);
    }

    public void setReligionType(FamilyRelationType familyRelationType) {
        this.familyRelationType = familyRelationType == null ? null : familyRelationType.getId();
    }
}