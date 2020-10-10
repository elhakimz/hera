package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EmployeeRequestType implements EnumClass<String> {

    LEAVE("Leave"),
    VACATION("Vacation"),
    SICK("Sickness"),
    MARRIAGE("Marriage"),
    PREGNANCY("Pregnancy"),
    DEATH("Death"),
    MEETUP("Meetup"),
    REMOTE("Remote Work"),
    REIMBURSE("Reimburse"),
    LOAN("Loan");

    private String id;

    EmployeeRequestType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EmployeeRequestType fromId(String id) {
        for (EmployeeRequestType at : EmployeeRequestType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}