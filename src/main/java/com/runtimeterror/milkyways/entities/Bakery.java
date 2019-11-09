package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bakery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bakeryid;
    private String bakeryname;
    private String address;
    private String phone;
}
