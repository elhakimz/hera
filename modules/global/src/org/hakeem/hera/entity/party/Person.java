package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.qualification.Course;
import org.hakeem.hera.entity.qualification.Education;
import org.hakeem.hera.entity.qualification.Skill;
import org.hakeem.hera.entity.types.Gender;
import org.hakeem.hera.entity.types.MaritalStatus;
import org.hakeem.hera.entity.types.ReligionType;
import org.hakeem.hera.entity.types.Salutation;
import org.slf4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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

    @Column(name = "RELIGION_TYPE")
    private String religionType;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;


    @OneToMany(mappedBy = "person")
    private List<Skill> skills;

    @OneToMany(mappedBy = "person")
    private List<Education> educations;

    @OneToMany(mappedBy = "person")
    private List<Course> courses;

    @Transient
    @MetaProperty
    private String otherInfo;


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

    public ReligionType getReligionType() {
        return religionType == null ? null : ReligionType.fromId(religionType);
    }

    public void setReligionType(ReligionType religionType) {
        this.religionType = religionType == null ? null : religionType.getId();
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus == null ? null : MaritalStatus.fromId(maritalStatus);
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.getId();
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
             this.setName(getFirstName()+" "+getLastName()+", "+getSalutation().getId());

    }



    public String getOtherInfo() {

        try {
            //address
            if(getAddresses()!=null){
                for(PartyAddress pa : getAddresses()){
                    otherInfo ="Live in "+pa.getCity()+", "+ pa.getCountry().getName();
                }

            }
        } catch (Exception e) {
            log.error("Error", e);
        }

        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @PreUpdate
    public void preUpdate() {
        this.setName(getFirstName()+" "+getLastName()+", "+getSalutation().getId());
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}