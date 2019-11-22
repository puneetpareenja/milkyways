package com.runtimeterror.milkyways.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressid;
    private String apt;
    private String street;
    private String city;
    private String postalcode;
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Customer customer;

    public Address() {

    }

    public Address(String apt, String street, String city, String postalcode, Customer customer) {
        this.apt = apt;
        this.street = street;
        this.city = city;
        this.postalcode = postalcode;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getAddressid() {
        return addressid;
    }

    public void setAddressid(long addressid) {
        this.addressid = addressid;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

}
