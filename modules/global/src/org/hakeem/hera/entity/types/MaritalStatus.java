package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MaritalStatus implements EnumClass<String> {

    MARRIED("Menikah"),
    UNMARRIED("Tidak Menikah"),
    DIVORCED("Bercerai");

    private final String id;

    MaritalStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MaritalStatus fromId(String id) {
        for (MaritalStatus at : MaritalStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}