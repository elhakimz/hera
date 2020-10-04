package org.hakeem.hera.entity.party;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hakeem.hera.entity.finance.BankAccount;
import org.hakeem.hera.entity.qualification.Skill;

import javax.persistence.*;
import java.util.List;

@javax.persistence.DiscriminatorValue("PARTY")
@Table(name = "HERA_PARTY")
@Entity(name = "hera_Party")
@NamePattern("%s|name")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Party extends StandardEntity {
    private static final long serialVersionUID = -705611384233901522L;

    @Column(name = "NAME", length = 100)
    private String name;

    @OneToMany(mappedBy = "party")
    private List<PartyIdentifier> identifiers;

    @OneToMany(mappedBy = "party")
    private List<PartyAddress> addresses;

    @OneToMany(mappedBy = "party")
    private List<PartyContact> contacts;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PHOTO_IMAGE_ID")
    private FileDescriptor photoImage;

    @OneToMany(mappedBy = "party")
    private List<BankAccount> bankAccounts;


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public FileDescriptor getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(FileDescriptor photoImage) {
        this.photoImage = photoImage;
    }

    public List<PartyIdentifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<PartyIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<PartyContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<PartyContact> contacts) {
        this.contacts = contacts;
    }

    public List<PartyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PartyAddress> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}