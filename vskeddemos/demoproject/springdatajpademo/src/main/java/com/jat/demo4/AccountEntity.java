package com.jat.demo4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "account")//表名
@Entity //实体 表示实体化后可以被跟踪
public class AccountEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 1372685190316027626L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "password")
    private String password;

    public AccountEntity() {
        //要有空构造
    }

    public AccountEntity(Long id, String accountName, String password) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
