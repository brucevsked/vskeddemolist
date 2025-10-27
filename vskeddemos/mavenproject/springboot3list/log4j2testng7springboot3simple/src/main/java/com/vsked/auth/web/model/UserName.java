package com.vsked.auth.web.model;

public class UserName {
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserName(String username) {
        this.username = username;
    }
    //必须要有空构造方法才可以
    public UserName() {
    }

    @Override
    public String toString() {
        return username;
    }
}
