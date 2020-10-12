package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum QuestionType implements EnumClass<String> {

    TEXT("Text"),
    NUMBER("Number"),
    DATE("Date"),
    BOOLEAN("Boolean"),
    SELECT("Selection"),
    MULTISELECT("Multiselect");

    private String id;

    QuestionType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static QuestionType fromId(String id) {
        for (QuestionType at : QuestionType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}