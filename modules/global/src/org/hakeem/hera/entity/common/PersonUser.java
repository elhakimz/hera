package org.hakeem.hera.entity.common;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;
import org.hakeem.hera.entity.party.Person;

import javax.persistence.*;

@Table(name = "HERA_PERSON_USER")
@Entity(name = "hera_PersonUser")
@NamePattern("%s|person, user")
public class PersonUser extends StandardEntity {
    private static final long serialVersionUID = -5236102759188711850L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERSON_ID")
    private Person person;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}