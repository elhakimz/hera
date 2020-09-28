package org.hakeem.hera.entity.finance;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AccountNumberType implements EnumClass<String> {

    IBAN("IBAN"),
    OTHER("OTHER");

    private String id;

    AccountNumberType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AccountNumberType fromId(String id) {
        for (AccountNumberType at : AccountNumberType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}