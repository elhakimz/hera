package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AttendanceType implements EnumClass<String> {

    PRESENT("Present"),
    NOTPRESENT("Not Present"),
    PERMITTEDLEAVE("Permitted Leave"),
    UNPERMITTEDLEAVE("Unpermitted Leave"),
    SICK("Sick"),
    VACATION("Vacation");

    private String id;

    AttendanceType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AttendanceType fromId(String id) {
        for (AttendanceType at : AttendanceType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}