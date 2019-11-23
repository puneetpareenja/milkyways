package com.runtimeterror.milkyways.entities;

import javax.persistence.*;

@Entity
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressid;
    private String apt;
    private String street;
    private String city;
    private String postalcode;
    private String country;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;

    public CustomerAddress() {
    }

    public long getAddressid() {
        return addressid;
    }

    public CustomerAddress setAddressid(long addressid) {
        this.addressid = addressid;
        return this;
    }

    public String getApt() {
        return apt;
    }

    public CustomerAddress setApt(String apt) {
        this.apt = apt;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public CustomerAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CustomerAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public CustomerAddress setPostalcode(String postalcode) {
        this.postalcode = postalcode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CustomerAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerAddress setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "addressid=" + addressid +
                ", apt='" + apt + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", country='" + country + '\'' +
                ", customer=" + customer +
                '}';
    }
}
