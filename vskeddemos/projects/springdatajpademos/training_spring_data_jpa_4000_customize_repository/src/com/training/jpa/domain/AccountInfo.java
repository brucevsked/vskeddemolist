package com.training.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="accountInfo")
public class AccountInfo implements Serializable
{

	private static final long serialVersionUID = 2976370972470573933L;

	private Long accountId;

    private UserInfo userInfo;

    private Integer balance;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getAccountId()
    {
        return accountId;
    }

    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    public Integer getBalance()
    {
        return balance;
    }

    public void setBalance(Integer balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "AccountInfo{" +
                "accountId=" + accountId +
                ", userInfo=" + userInfo +
                ", balance=" + balance +
                '}';
    }
}
