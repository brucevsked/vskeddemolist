package com.vsked.demo5;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "driverMan")//表名
@Entity //实体 表示实体化后可以被跟踪
public class DriverMan implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 3992382975386686109L;

    @Id
    @Column(name = "id")
    private String id;
    private String name;

    /**
     * joinTable开一张中间表
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "driverManCard",joinColumns = {@JoinColumn(name = "driverManId")},inverseJoinColumns = {@JoinColumn(name = "driverCardId")})
    private DriverCard driverCard;

    public DriverMan() {
    }

    public DriverMan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DriverMan(String id, String name, DriverCard driverCard) {
        this.id = id;
        this.name = name;
        this.driverCard = driverCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DriverCard getDriverCard() {
        return driverCard;
    }

    public void setDriverCard(DriverCard driverCard) {
        this.driverCard = driverCard;
    }

    @Override
    public String toString() {
        if(driverCard==null){
            return "DriverMan{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
        return "DriverMan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", driverCard=" + driverCard +
                '}';
    }
}
