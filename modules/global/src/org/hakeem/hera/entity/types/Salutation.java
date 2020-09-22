package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Salutation implements EnumClass<String> {

    MR("Mr"),
    MRS("Mrs"),
    ESQ("Esquire"),
    MADAM("Madam");

    private String id;

    Salutation(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Salutation fromId(String id) {
        for (Salutation at : Salutation.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}