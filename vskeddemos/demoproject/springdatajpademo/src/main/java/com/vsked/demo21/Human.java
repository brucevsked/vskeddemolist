package com.vsked.demo21;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "human")
public class Human implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -2723419192837801956L;

    @Id
    private Long id;
    private String name;

    public Human() {
    }

    public Human(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
