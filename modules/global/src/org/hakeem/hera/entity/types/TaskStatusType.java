package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TaskStatusType implements EnumClass<String> {


    PENDING("Pending"),
    INPROGRESS("In Progress"),
    DONE("Done"),
    CANCELLED("Cancelled"),
    FORWARDED("Forwarded");

    private String id;

    TaskStatusType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TaskStatusType fromId(String id) {
        for (TaskStatusType at : TaskStatusType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}