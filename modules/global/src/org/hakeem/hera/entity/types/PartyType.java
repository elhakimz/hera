package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PartyType implements EnumClass<String> {

    PERSON("Person"),
    ORGANIZATION("Organization");

    private final String id;

    PartyType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PartyType fromId(String id) {
        for (PartyType at : PartyType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}