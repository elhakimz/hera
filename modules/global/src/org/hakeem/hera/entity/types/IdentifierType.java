package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum IdentifierType implements EnumClass<String> {

    KTP("Ktp"),
    NPWP("Npwp"),
    PASSPORT("Passport"),
    BPJS("Bpjs"),
    BPJSTK("BPJSTK");

    private String id;

    IdentifierType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static IdentifierType fromId(String id) {
        for (IdentifierType at : IdentifierType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}