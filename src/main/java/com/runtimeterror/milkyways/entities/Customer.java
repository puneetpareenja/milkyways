package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Address address;
    private int phone;
    private Card card;
}