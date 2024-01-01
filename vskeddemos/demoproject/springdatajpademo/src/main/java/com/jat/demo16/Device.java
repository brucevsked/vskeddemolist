package com.jat.demo16;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "device")
@Entity
public class Device implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 131391210004857374L;

    @Id
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private String width;
    private String height;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Device() {
    }

    public Device(Long id, String name, String type, Integer price, String width, String height) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.width = width;
        this.height = height;
    }
}
