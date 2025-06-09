package com.vsked.demo5;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "driverCard")//表名
@Entity //实体 表示实体化后可以被跟踪
public class DriverCard implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -2906418646558387472L;

    @Id
    @Column(name = "id")
    private String id;
    private String number;
    private String expireDate;

    public DriverCard() {
    }

    public DriverCard(String id, String number, String expireDate) {
        this.id = id;
        this.number = number;
        this.expireDate = expireDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "DriverCard{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
