package com.example.rmcserviceapp.model;

import java.time.LocalDate;

public class Customer {
    private LocalDate date;
    private String time, orderNumber, name, address, contact, siteName;

    public Customer(LocalDate date, String time, String orderNumber, String name, String address, String contact, String siteName) {
        this.date = date;
        this.time = time;
        this.orderNumber = orderNumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.siteName = siteName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "date=" + date +
                ", time='" + time + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", siteName='" + siteName + '\'' +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
