package com.jat.model.business;

public class DateType {
    private Integer id;
    private String name;

    public DateType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name  +
                "}";
    }
}
