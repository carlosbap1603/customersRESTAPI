package com.amdocs.badillo.customers.entities;

public class Product {

    private long id;
    private String name;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
