package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EmploymentApplyStepType implements EnumClass<String> {
    SOURCED("Sourced"),
    APPLICANT("Applicant"),
    CANDIDATE("Candidate"),
    INTERVIEWED1("Interviewed1"),
    INTERVIEWED2("Interviewed2"),
    OFFERED("Offered"),
    REJECTED("Rejected"),
    HIRED("Hired");

    private final String id;

    EmploymentApplyStepType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EmploymentApplyStepType fromId(String id) {
        for (EmploymentApplyStepType at : EmploymentApplyStepType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}