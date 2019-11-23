package com.runtimeterror.milkyways.entities;

import javax.persistence.*;

@Entity
public class StoreAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressid;
    private String apt;
    private String street;
    private String city;
    private String postalcode;
    private String country;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Store store;

    public StoreAddress() {
    }

    public long getAddressid() {
        return addressid;
    }

    public StoreAddress setAddressid(long addressid) {
        this.addressid = addressid;
        return this;
    }

    public String getApt() {
        return apt;
    }

    public StoreAddress setApt(String apt) {
        this.apt = apt;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public StoreAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public StoreAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public StoreAddress setPostalcode(String postalcode) {
        this.postalcode = postalcode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public StoreAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public StoreAddress setStore(Store store) {
        this.store = store;
        return this;
    }
}
