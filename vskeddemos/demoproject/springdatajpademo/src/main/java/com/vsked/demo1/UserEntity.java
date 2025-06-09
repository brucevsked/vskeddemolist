package com.vsked.demo1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "user")//表名
@Entity //实体 表示实体化后可以被跟踪
public class UserEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 2720000416412785792L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "uid",columnDefinition = "bigint") //列名与列定义
    private Long uid;

    @Column(name = "userName")
    private String userName;

    public UserEntity() {
        //要有空构造
    }

    public UserEntity(Long uid, String userName) {
        this.uid = uid;
        this.userName = userName;
    }

    //要有getter,setter
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                '}';
    }
}
