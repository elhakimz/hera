package org.hakeem.hera.entity.payroll;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PeriodType implements EnumClass<String> {

    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    YEARLY("Yearly");

    private String id;

    PeriodType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PeriodType fromId(String id) {
        for (PeriodType at : PeriodType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}