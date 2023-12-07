package com.vsked.bookborrow.web.VO.auth.login;


public class AccountNamePasswordVO {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    public AccountNamePasswordVO(String name, String password) {

        //TODO check1
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //TODO check2
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //TODO check3
        this.password = password;
    }
}
