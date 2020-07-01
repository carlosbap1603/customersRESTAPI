package com.amdocs.badillo.customers.entities;

public class Action {

    private long id;
    private String name;

    public Action(long id, String name) {
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
