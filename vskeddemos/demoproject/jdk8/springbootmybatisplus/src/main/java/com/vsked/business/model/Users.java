package com.vsked.business.model;

import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;

public class Users {

    //解决无法使用selectById取数据问题
    @TableId(value = "uid")
    private long uid;
    private String uname;
    private String upass;
    private LocalDate ubirth;


    public Users() {
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public LocalDate getUbirth() {
        return ubirth;
    }

    public void setUbirth(LocalDate ubirth) {
        this.ubirth = ubirth;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", ubirth=" + ubirth +
                '}';
    }
}
