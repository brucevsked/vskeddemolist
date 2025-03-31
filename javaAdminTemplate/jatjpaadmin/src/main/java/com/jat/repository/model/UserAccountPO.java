package com.jat.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userAccount")
public class UserAccountPO implements Serializable {

    @EmbeddedId
    private UserAccountPK id;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private UserPO user;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    private AccountPO account;

    private Integer isDel;

    public UserAccountPO() {
    }

    public UserAccountPO(UserPO user, AccountPO account) {
        this.id=new UserAccountPK(user.getId(),account.getId());
        this.user = user;
        this.account = account;
        this.isDel=0;
    }

    public UserAccountPO(UserPO user, AccountPO account, Integer isDel) {
        this.id = new UserAccountPK(user.getId(),account.getId());
        this.user = user;
        this.account = account;
        this.isDel = isDel;
    }

    public UserAccountPK getId() {
        return id;
    }

    public void setId(UserAccountPK id) {
        this.id = id;
    }

    public UserPO getUser() {
        return user;
    }

    public void setUser(UserPO user) {
        this.user = user;
    }

    public AccountPO getAccount() {
        return account;
    }

    public void setAccount(AccountPO account) {
        this.account = account;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "UserAccountPO{" +
                "id=" + id +
                ", user=" + user +
                ", account=" + account +
                ", isDel=" + isDel +
                '}';
    }
}
