package org.hakeem.hera.entity.commevent;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CommunicationEventStatusType implements EnumClass<String> {

    COMPLETED("Komplit"),
    SCHEDULED("Dijadwal"),
    PENDING("Ditunda");


    private String id;

    CommunicationEventStatusType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CommunicationEventStatusType fromId(String id) {
        for (CommunicationEventStatusType at : CommunicationEventStatusType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}