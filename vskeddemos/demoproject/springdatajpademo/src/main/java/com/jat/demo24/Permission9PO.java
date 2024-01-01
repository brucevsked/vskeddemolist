package com.jat.demo24;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "permission9")
@Entity
public class Permission9PO implements Serializable {
    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -3496682285643006458L;

    @Id
    private Long id;
    private String name;

    public Permission9PO() {
    }

    public Permission9PO(Long id, String name) {
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
        return "{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
