package com.vsked.system.model.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "account")
@Entity
public class AccountPO implements Serializable {

    @Serial
    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 2589051058614650816L;

    @Id
    private Long id;
    private String accountName;
    private String password;

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

    public AccountPO() {
    }

    public AccountPO(Long id, String accountName, String password) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
