package com.jat.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Table(name = "account")
@Entity
public class AccountPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String pass;
    private Integer isDel;

    @OneToOne(mappedBy = "account",cascade = CascadeType.DETACH)
    UserAccountPO userAccount;

    public AccountPO() {
    }

    public AccountPO(Integer id, String name, String pass, Integer isDel) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public UserAccountPO getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountPO userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "AccountPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
