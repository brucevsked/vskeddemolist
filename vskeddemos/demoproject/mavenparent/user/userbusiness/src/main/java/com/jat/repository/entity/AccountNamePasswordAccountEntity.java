package com.jat.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account")
@Entity
public class AccountNamePasswordAccountEntity {

    @Id
    @Column(name = "accountName")
    private String accountName;

    @Column(name = "password")
    private String password;

    public AccountNamePasswordAccountEntity() {
    }

    public AccountNamePasswordAccountEntity(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
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
}
