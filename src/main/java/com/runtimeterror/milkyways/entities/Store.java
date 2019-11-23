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

    @OneToOne(mappedBy = "store", fetch = FetchType.EAGER)
    private StoreAddress storeAddress;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private List<Item> itemlist = new ArrayList<>();

    public Store() {
    }

    public long getStoreid() {
        return storeid;
    }

    public Store setStoreid(long storeid) {
        this.storeid = storeid;
        return this;
    }

    public String getStorename() {
        return storename;
    }

    public Store setStorename(String storename) {
        this.storename = storename;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Store setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<Item> getItemlist() {
        return itemlist;
    }

    public Store setItemlist(List<Item> itemlist) {
        this.itemlist = itemlist;
        return this;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeid=" + storeid +
                ", storename='" + storename + '\'' +
                ", phone='" + phone + '\'' +
                ", itemlist=" + itemlist +
                '}';
    }
}

