package com.amdocs.badillo.customers.entities;


import java.io.Serializable;

public class Customer implements Serializable {

    private long id;
    private String name;
    private String photo;

    public Customer(long id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
