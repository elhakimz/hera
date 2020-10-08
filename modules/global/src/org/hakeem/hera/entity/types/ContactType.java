package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ContactType implements EnumClass<String> {

    PHONE("Phone"),
    EMAIL("Email"),
    WEBSITE("Website"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    WHATSAPP("Whatsapp");

    private final String id;

    ContactType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ContactType fromId(String id) {
        for (ContactType at : ContactType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}