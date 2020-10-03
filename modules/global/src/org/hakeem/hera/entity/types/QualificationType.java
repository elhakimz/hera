package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum QualificationType implements EnumClass<String> {

    CERTIFICATION("Certification"),
    DEGREE("Degree") ;


    private String id;

    QualificationType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static QualificationType fromId(String id) {
        for (QualificationType at : QualificationType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}