package com.vsked.demo8;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "desk",indexes = {@Index(name = "deskNameIndex",columnList = "name",unique = true)})//表名
@Entity //实体 表示实体化后可以被跟踪
public class DeskPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 1256431893632772845L;

    @Id
    private Long id;
    private String name;
    private Date addTime;

    public DeskPO() {
    }

    public DeskPO(Long id, String name, Date addTime) {
        this.id = id;
        this.name = name;
        this.addTime = addTime;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime=" + addTime +
                "}";
    }
}
