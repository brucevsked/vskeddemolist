package com.jat.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
public class PlatformUserAccountPK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -479721429493047716L;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "accountId")
    private Long accountId;

    public PlatformUserAccountPK() {
    }

    public PlatformUserAccountPK(Long userId, Long accountId) {
        this.accountId = accountId;
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", accountId=" + accountId +
                '}';
    }
}
