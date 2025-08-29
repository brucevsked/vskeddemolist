package com.vsked.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "b1")//表名
@Entity
public class B1 {

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B1() {
    }

    @Override
    public String toString() {
        return "B1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
