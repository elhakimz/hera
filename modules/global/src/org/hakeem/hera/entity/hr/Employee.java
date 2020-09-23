package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import org.hakeem.hera.entity.party.PartyRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

@javax.persistence.DiscriminatorValue("EMPLOYEE")
@Entity(name = "hera_Employee")
@NamePattern("%s|name")
public class Employee extends PartyRole {
    private static final long serialVersionUID = -8297129083732717267L;

    @CaseConversion
    @Column(name = "EMP_CODE",  length = 11)
    @NotNull
    private String empCode;

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @PrePersist
    public void prePersist() {
          if(getParty()!=null){
              this.setName(getParty().getName()+"("+this.getEmpCode()+")");
              this.setDescription(getParty().getName()+", Employee No:"+this.getEmpCode()+"");
          }

    }
}