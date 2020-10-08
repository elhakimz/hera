package org.hakeem.hera.entity.agreement;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AgreementType implements EnumClass<String> {
    SALES("Sales"),
    PURCHASE("Purchase"),
    EMPLOYMENT("Employment"),
    OTHER("Other")
    ;

    private final String id;

    AgreementType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AgreementType fromId(String id) {
        for (AgreementType at : AgreementType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}