package com.runtimeterror.milkyways.entities;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Card {
    private long number;
    private Date expiryDate;
    private String name;

}
