package com.jat.manager.business;

public class AccountPassword {

    private String password;

    public AccountPassword(String password) {
        if(password==null){
            throw new IllegalArgumentException("账户密码不能为空");
        }
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return password;
    }
}
