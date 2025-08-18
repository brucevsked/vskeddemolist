package com.vsked.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Table(name = "users")//表名
@Entity //实体
public class Users {

    @Id
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public LocalDate getUbirth() {
        return ubirth;
    }

    public void setUbirth(LocalDate ubirth) {
        this.ubirth = ubirth;
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
