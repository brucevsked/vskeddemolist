package com.vsked.auth.web.model;

public class UserDto {
    private UserName username;
    private PassWord password;

    public UserName getUsername() {
        return username;
    }

    public void setUsername(UserName username) {
        this.username = username;
    }

    public PassWord getPassword() {
        return password;
    }

    public void setPassword(PassWord password) {
        this.password = password;
    }

    public UserDto(UserName username, PassWord password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username=" + username +
                ", password=" + password +
                '}';
    }
}
