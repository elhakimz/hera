package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum FamilyRelationType implements EnumClass<String> {

    HUSBAND("Suami"),
    WIFE("Istri"),
    SON("Anak laki laki"),
    DAUGHTER("Anak Perempuan"),;

    private final String id;

    FamilyRelationType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static FamilyRelationType fromId(String id) {
        for (FamilyRelationType at : FamilyRelationType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}