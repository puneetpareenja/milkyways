package com.runtimeterror.milkyways.entities;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;
    private String name;
    private String imageurl;
    private int quantity;
    private boolean type; //0: sweet, 1: savoury
    private boolean sugarfree; //0: w/ sugar, 1: sugarfree
    private boolean glutenfree; //0: not, 1: glutenfree
    private boolean dairyfree; //0: not, 1: dairyfree
    private boolean vegetarian; //0: not, 1: vegetarian
    private float price;
    private int rating; //1 to 5 stars

    @ManyToOne
    @JoinColumn(name = "storeid")
    private Store store;

    public Item() {
    }

    public Item(String name, String imageurl, int quantity, boolean type, boolean sugarfree, boolean glutenfree, boolean dairyfree, boolean vegetarian, float price, int rating,  Store store) {
        this.name = name;
        this.imageurl = imageurl;
        this.quantity = quantity;
        this.type = type;
        this.sugarfree = sugarfree;
        this.glutenfree = glutenfree;
        this.dairyfree = dairyfree;
        this.vegetarian = vegetarian;
        this.price = price;
        this.rating = rating;
        this.store = store;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isSugarfree() {
        return sugarfree;
    }

    public void setSugarfree(boolean sugarfree) {
        this.sugarfree = sugarfree;
    }

    public boolean isGlutenfree() {
        return glutenfree;
    }

    public void setGlutenfree(boolean glutenfree) {
        this.glutenfree = glutenfree;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isDairyfree() { return dairyfree; }

    public int getRating() { return rating; }

    public void setDairyfree(boolean dairyfree) { this.dairyfree = dairyfree; }

    public void setRating(int rating) { this.rating = rating; }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
