package com.runtimeterror.milkyways.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerid;
    private String firstname;
    private String lastname;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Address> addressset = new HashSet<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Card> cardlist = new HashSet<>();

    public Customer() {

    }

    public Customer(String firstname, String lastname, String password, String email, String phone, Set<Address> addressset, Set<Card> cardlist) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.addressset = addressset;
        this.cardlist = cardlist;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Address> getAddressset() {
        return addressset;
    }

    public void setAddressset(Set<Address> addressset) {
        this.addressset = addressset;
    }

    public Set<Card> getCardlist() {
        return cardlist;
    }

    public void setCardlist(Set<Card> cardlist) {
        this.cardlist = cardlist;
    }
}