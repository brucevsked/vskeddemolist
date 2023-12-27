package com.jat.domain;

public class Account {
    private long id;
    private String name;
    private String pass;

    public Account(long id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
