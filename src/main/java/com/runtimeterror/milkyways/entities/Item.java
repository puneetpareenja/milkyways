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
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Store store;

    public Item() {
    }

    public long getItemid() {
        return itemid;
    }

    public Item setItemid(long itemid) {
        this.itemid = itemid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Item setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public boolean isType() {
        return type;
    }

    public Item setType(boolean type) {
        this.type = type;
        return this;
    }

    public boolean isSugarfree() {
        return sugarfree;
    }

    public Item setSugarfree(boolean sugarfree) {
        this.sugarfree = sugarfree;
        return this;
    }

    public boolean isGlutenfree() {
        return glutenfree;
    }

    public Item setGlutenfree(boolean glutenfree) {
        this.glutenfree = glutenfree;
        return this;
    }

    public boolean isDairyfree() {
        return dairyfree;
    }

    public Item setDairyfree(boolean dairyfree) {
        this.dairyfree = dairyfree;
        return this;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Item setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Item setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Item setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public Item setStore(Store store) {
        this.store = store;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemid=" + itemid +
                ", name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", quantity=" + quantity +
                ", type=" + type +
                ", sugarfree=" + sugarfree +
                ", glutenfree=" + glutenfree +
                ", dairyfree=" + dairyfree +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                ", rating=" + rating +
                ", store=" + store +
                '}';
    }
}
