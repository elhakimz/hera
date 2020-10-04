package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import org.hakeem.hera.entity.party.PartyRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@javax.persistence.DiscriminatorValue("EMPLOYEE")
@Entity(name = "hera_Employee")
@NamePattern("%s|name")
public class Employee extends PartyRole {
    private static final long serialVersionUID = -8297129083732717267L;

    @CaseConversion
    @Column(name = "EMP_CODE", length = 11)
    @NotNull
    private String empCode;

    @OneToMany(mappedBy = "acceptedBy")
    private List<PositionFulfillment> positionFulfillments;

    public List<PositionFulfillment> getPositionFulfillments() {
        return positionFulfillments;
    }

    public void setPositionFulfillments(List<PositionFulfillment> positionFulfillments) {
        this.positionFulfillments = positionFulfillments;
    }

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


    @PreUpdate
    public void preUpdate() {
        if(getParty()!=null){
            this.setName(getParty().getName()+"("+this.getEmpCode()+")");
            this.setDescription(getParty().getName()+", Employee No:"+this.getEmpCode()+"");
        }
    }
}