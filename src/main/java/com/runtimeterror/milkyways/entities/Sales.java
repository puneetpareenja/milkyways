package com.runtimeterror.milkyways.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long salesid;

    @OneToOne
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany
    private List<Item> itemlist = new ArrayList<>();

    private double total;

    public Sales() {
    }

    public Sales(Customer customer, Date date, List<Item> itemlist, double total) {
        this.customer = customer;
        this.date = date;
        this.itemlist = itemlist;
        this.total = total;
    }

    public long getSalesid() {
        return salesid;
    }

    public void setSalesid(long salesid) {
        this.salesid = salesid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<Item> itemlist) {
        this.itemlist = itemlist;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesid=" + salesid +
                ", customer=" + customer +
                ", date=" + date +
                ", itemlist=" + itemlist +
                ", total=" + total +
                '}';
    }
}
