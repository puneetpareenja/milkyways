package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Card {
    @Id
    private long number;
    @Temporal(TemporalType.DATE)
    private Date expirydate;
    private int cvv;
    private String cardholder;

    public Card() {
    }

    public Card(long number, Date expirydate, int cvv, String cardholder) {
        this.number = number;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.cardholder = cardholder;
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
