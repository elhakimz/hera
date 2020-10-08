package org.hakeem.hera.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = RestRole.NAME, securityScope = "REST")
public class RestRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Rest";

}
