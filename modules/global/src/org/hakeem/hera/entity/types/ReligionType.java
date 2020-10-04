package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ReligionType implements EnumClass<String> {

    HINDU("Hindu"),
    BUDDHA("Buddha"),
    CONFUCIUS("Konghucu"),
    JUDAISM("Yahudi"),
    CATHOLIC("Catholic"),
    CHRISTIAN("Kristen"),
    ISLAM("Islam"),
    ATHEIST("Ateis"),
    OTHER("Lainnya");


    private String id;

    ReligionType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ReligionType fromId(String id) {
        for (ReligionType at : ReligionType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}