package com.proje.model;

import com.proje.model.util.PhoneType;

import javax.persistence.*;
import java.util.*;

@Entity
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personalId;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    @ElementCollection
    @CollectionTable(name = "personel_personelNumber", joinColumns = @JoinColumn(name = "personelId"))
    @MapKeyColumn(name="phoneType")
//    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "phoneNumber")
    private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();


    public Personel() {
    }

    public Personel(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }

    public void addPhoneNumber(PhoneType phoneType, String phoneNumber){

        this.phoneNumbers.put(phoneType,phoneNumber);

    }

    public int getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
