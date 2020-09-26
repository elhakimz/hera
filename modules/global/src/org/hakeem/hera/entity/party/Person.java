package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.types.Gender;
import org.hakeem.hera.entity.types.Salutation;
import org.slf4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@javax.persistence.DiscriminatorValue("PERSON")
@Entity(name = "hera_Person")
@NamePattern("%s|name")
public class Person extends Party {
    private static final long serialVersionUID = 7053738058657349224L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Person.class);

    @Column(name = "SALUTATION")
    private String salutation;

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    private String middleName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "BIRTH_PLACE", length = 100)
    private String birthPlace;

    @Transient
    @MetaProperty
    private Integer age;

    @Column(name = "GENDER")
    private String gender;

    public Integer getAge() {
        try {
            if(getBirthDate()!=null){
               Period period = Period.between(getBirthDate(), LocalDate.now());
               age = period.getYears();
            }
        } catch (Exception e) {
            log.error("Error", e);
        }
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Salutation getSalutation() {
        return salutation == null ? null : Salutation.fromId(salutation);
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation == null ? null : salutation.getId();
    }

    public Gender getGender() {
        return gender == null ? null : Gender.fromId(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @PrePersist
    public void prePersist() {
             this.setName(firstName+" "+lastName+", "+getSalutation().name());

    }
}