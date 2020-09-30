package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.NamePattern;
import org.hakeem.hera.entity.party.PartyRole;
import org.slf4j.Logger;

import javax.persistence.*;

@javax.persistence.DiscriminatorValue("COMPANY")
@Entity(name = "hera_Company")
@NamePattern("%s|name")
public class Company extends PartyRole {
    private static final long serialVersionUID = -3310721788063181548L;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Company.class);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARENT_COMPANY_ID")
    private Company parentCompany;

    public Company getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
    }


    public  void updateDescription(){
        try {
            if(getParty()!=null && (getName()==null || getName().isEmpty())){
                setName(getParty().getName());
                if(getDescription()==null){
                    if(getParentCompany()==null){
                        setDescription(getParty().getName()+",Company");
                    }else{
                        setDescription(getParty().getName()+",Subsidiary");
                    }
                }

            }
        } catch (Exception e) {
            log.error("Error", e);
        }
    }

    @PrePersist
    public void prePersist() {
       updateDescription();
    }


    @PreUpdate
    public void preUpdate() {
         updateDescription();
    }
}