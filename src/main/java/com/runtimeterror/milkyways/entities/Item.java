package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;
    private long storeId;
    private String name;
    private long quantity;
    private boolean type; //0: sweet, 1: savoury
    private boolean sugarFree;
    private boolean glutenFree;
    private boolean vegetarian;
    private float price;
}
