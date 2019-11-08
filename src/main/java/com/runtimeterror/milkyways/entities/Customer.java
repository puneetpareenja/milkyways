package com.runtimeterror.milkyways.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int custid;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private Address address;
    private int phone;
    private Card card;
}