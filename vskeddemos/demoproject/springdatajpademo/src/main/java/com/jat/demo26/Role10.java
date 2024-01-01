package com.jat.demo26;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "role10")
@Entity
public class Role10 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 8101174767276468469L;

    @Id
    private Long id;
    private String name;

    public Role10() {
    }

    public Role10(Long id, String name) {
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
                ", name=" + name  +
                "}";
    }
}
