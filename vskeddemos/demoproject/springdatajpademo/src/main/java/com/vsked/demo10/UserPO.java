package com.vsked.demo10;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "user1")//表名
@Entity //实体 表示实体化后可以被跟踪
public class UserPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -1128008212186870463L;

    @Id
    private Long id;
    private String name;

    public UserPO() {
    }

    public UserPO(Long id, String name) {
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
}
