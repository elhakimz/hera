package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.types.Gender;
import org.hakeem.hera.entity.types.PartyType;
import org.hakeem.hera.entity.types.Salutation;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@MappedSuperclass
@NamePattern("%s|name")
public class Person extends Party {
    private static final long serialVersionUID = 7053738058657349224L;

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

    @Column(name = "GENDER")
    private String gender;

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
         if(this.getPartyType()==null){
             this.setPartyType(PartyType.PERSON);
             this.setName(firstName+" "+lastName+", "+getSalutation().name());
         }
    }
}