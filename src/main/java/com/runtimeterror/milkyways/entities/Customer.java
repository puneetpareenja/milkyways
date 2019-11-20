package com.runtimeterror.milkyways.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    @JoinColumn(name = "addressid")
    private List<Address> addressList = new ArrayList<>();
    @ManyToMany
    @JoinColumn(name="cardnumber")
    private List<Card> cardList = new ArrayList<>();

    public Customer() {

    }

    public Customer(String firstname, String lastname, String password, String email,
                    String phone, List<Address> addressList, List<Card> cardList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.addressList = addressList;
        this.cardList = cardList;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}