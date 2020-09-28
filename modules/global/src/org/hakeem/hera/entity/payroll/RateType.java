package org.hakeem.hera.entity.payroll;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum RateType implements EnumClass<String> {

    HIGHEST("Highest"),
    LOWEST("Lowest"),
    STANDARD("Standard");

    private String id;

    RateType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static RateType fromId(String id) {
        for (RateType at : RateType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}