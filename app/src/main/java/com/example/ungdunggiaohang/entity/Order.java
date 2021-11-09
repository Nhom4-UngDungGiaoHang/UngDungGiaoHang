package com.example.ungdunggiaohang.entity;

import java.util.Date;

public class Order {
    private String id;
    private double cost;
    private String namePackage;
    private Date dateSeen;
    private String from;
    private String to;

    public Order() {
    }

    public Order(String id, double cost, String namePackage, Date dateSeen, String from, String to) {
        this.id = id;
        this.cost = cost;
        this.namePackage = namePackage;
        this.dateSeen = dateSeen;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNamePackage() {
        return namePackage;
    }

    public void setNamePackage(String namePackage) {
        this.namePackage = namePackage;
    }

    public Date getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(Date dateSeen) {
        this.dateSeen = dateSeen;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", namePackage='" + namePackage + '\'' +
                ", dateSeen=" + dateSeen +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
