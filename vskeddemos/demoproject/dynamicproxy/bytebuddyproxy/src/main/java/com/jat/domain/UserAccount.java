package com.jat.domain;

public class UserAccount {
    private User user;
    private Account account;

    public UserAccount(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public Account getAccount() {
        return account;
    }

    public void login(String accountPass){
        if(!account.getPass().equals(accountPass)){
            throw new IllegalArgumentException("账号密码错误！");
        }
    }
}
