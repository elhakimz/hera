package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Gender implements EnumClass<String> {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String id;

    Gender(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Gender fromId(String id) {
        for (Gender at : Gender.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}