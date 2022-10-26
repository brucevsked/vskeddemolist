package com.jat.po;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "platformUserAccount")
public class PlatformUserAccountPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -8002775002403230309L;

    @EmbeddedId
    private PlatformUserAccountPK id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    private PlatformUserPO user;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId",insertable = false,updatable = false)
    private PlatformAccountPO account;

    public PlatformUserAccountPO() {
    }

    public PlatformUserAccountPO(PlatformUserPO user, PlatformAccountPO account) {
        this.id=new PlatformUserAccountPK(user.getId(),account.getId());
        this.user = user;
        this.account = account;
    }

    public PlatformUserAccountPK getId() {
        return id;
    }

    public void setId(PlatformUserAccountPK id) {
        this.id = id;
    }

    public PlatformUserPO getUser() {
        return user;
    }

    public void setUser(PlatformUserPO user) {
        this.user = user;
    }

    public PlatformAccountPO getAccount() {
        return account;
    }

    public void setAccount(PlatformAccountPO account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user=" + user +
                ", account=" + account +
                '}';
    }
}
