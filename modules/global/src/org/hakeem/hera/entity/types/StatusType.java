package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusType implements EnumClass<String> {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    FULFILLED("Fulfilled");

    private final String id;

    StatusType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StatusType fromId(String id) {
        for (StatusType at : StatusType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}