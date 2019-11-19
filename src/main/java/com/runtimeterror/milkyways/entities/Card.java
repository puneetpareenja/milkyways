package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Card {
    @Id
    private long number;
    private Date expirydate;
    private String name;

}
