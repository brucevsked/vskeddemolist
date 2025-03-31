package com.jat.repository.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAccountPK implements Serializable {


    private Integer userId;

    private Integer accountId;

    public UserAccountPK() {
    }

    public UserAccountPK(Integer userId, Integer accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", accountId=" + accountId +
                '}';
    }
}
