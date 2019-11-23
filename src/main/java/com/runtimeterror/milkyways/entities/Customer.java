package com.runtimeterror.milkyways.entities;

import javax.persistence.*;

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
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private CustomerAddress customerAddress;
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private Card card;

    public Customer() {
    }

    public long getCustomerid() {
        return customerid;
    }

    public Customer setCustomerid(long customerid) {
        this.customerid = customerid;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Customer setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Customer setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public Customer setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public Customer setCard(Card card) {
        this.card = card;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", customerAddress=" + customerAddress +
                ", card=" + card +
                '}';
    }
}