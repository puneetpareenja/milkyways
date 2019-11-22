package com.runtimeterror.milkyways.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    public Card() {
    }

    public Card(long number, Date expirydate, int cvv, String cardholder, Customer customer) {
        this.number = number;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.cardholder = cardholder;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }
}
