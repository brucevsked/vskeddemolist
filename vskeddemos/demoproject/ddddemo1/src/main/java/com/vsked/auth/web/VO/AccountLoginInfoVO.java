package com.vsked.auth.web.VO;

/**
 * 账户登录信息界面对象
 */
public class AccountLoginInfoVO {

    /**
     * 账户登录名称
     */
    private String name;

    /**
     * 账户登录密码
     */
    private String password;

    /**
     * 必须要有无参构造函数
     */
    public AccountLoginInfoVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountLoginInfoVO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
