package com.vsked.auth.web.model;

public class PassWord {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PassWord(String password) {
        this.password = password;
    }
    //必须要有空构造方法才可以
    public PassWord() {
    }

    @Override
    public String toString() {
        return password;
    }
}
