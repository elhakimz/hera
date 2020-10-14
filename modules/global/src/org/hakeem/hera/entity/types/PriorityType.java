package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PriorityType implements EnumClass<String> {

    NONE("None"),
    LOW("Low"),
    STANDARD("Standard"),
    URGENT("Urgent"),
    IMPORTANT("Important"),
    VERY_IMPORTANT("Very Important"),
    CRITICAL("Critical");

    private String id;

    PriorityType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PriorityType fromId(String id) {
        for (PriorityType at : PriorityType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}