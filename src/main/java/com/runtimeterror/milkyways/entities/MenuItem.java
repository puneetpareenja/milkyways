package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemid;
    private int bakeryid;
    private String name;
    private int quantity;
    private boolean type; //0: sweet, 1: savoury
    private boolean sugarfree;
    private boolean glutenfree;
    private boolean vegetarian;
    private float price;
}
