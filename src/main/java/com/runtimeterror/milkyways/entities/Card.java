package com.runtimeterror.milkyways.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Card {
    @Id
    private long number;
    @Temporal(TemporalType.DATE)
    private Date expirydate;
    private int cvv;
    private String cardholder;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;

    public Card() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public Card setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public Card setNumber(long number) {
        this.number = number;
        return this;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public Card setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
        return this;
    }

    public int getCvv() {
        return cvv;
    }

    public Card setCvv(int cvv) {
        this.cvv = cvv;
        return this;
    }

    public String getCardholder() {
        return cardholder;
    }

    public Card setCardholder(String cardholder) {
        this.cardholder = cardholder;
        return this;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", expirydate=" + expirydate +
                ", cvv=" + cvv +
                ", cardholder='" + cardholder + '\'' +
                ", customer=" + customer +
                '}';
    }
}
