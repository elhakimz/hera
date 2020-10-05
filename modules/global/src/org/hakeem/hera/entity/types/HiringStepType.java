package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum HiringStepType implements EnumClass<String> {
    SOURCED("Sourced"),
    APPLICANT("Applicant"),
    CANDIDATE("Candidate"),
    INTERVIEWED1("Interviewed1"),
    INTERVIEWED2("Interviewed2"),
    OFFERED("Offered"),
    REJECTED("Rejected"),
    HIRED("Hired");

    private String id;

    HiringStepType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static HiringStepType fromId(String id) {
        for (HiringStepType at : HiringStepType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}