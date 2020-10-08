package org.hakeem.hera.entity.types;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum SkillLevelType implements EnumClass<String> {
    NEWBIE("Newbie"),
    BASIC("Basic"),
    INTERMEDIATE("Intermediate"),
    EXPERT("Expert");

    private final String id;

    SkillLevelType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static SkillLevelType fromId(String id) {
        for (SkillLevelType at : SkillLevelType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}