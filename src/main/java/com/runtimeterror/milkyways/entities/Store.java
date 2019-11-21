package com.runtimeterror.milkyways.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storeid;
    private String storename;
    private String phone;

    @OneToOne
    @JoinColumn(name="addressid")
    private Address address;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Item> itemlist = new ArrayList<>();

    public Store() {
    }

    public Store(String storename, String phone, Address address, List<Item> itemlist) {
        this.storename = storename;
        this.phone = phone;
        this.address = address;
        this.itemlist = itemlist;
    }

    public long getStoreid() {
        return storeid;
    }

    public void setStoreid(long storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<Item> itemlist) {
        this.itemlist = itemlist;
    }
}

