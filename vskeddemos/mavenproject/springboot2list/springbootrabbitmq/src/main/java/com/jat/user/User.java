package com.jat.user;

import java.io.Serializable;

public class User implements Serializable {
    private int uid;
    private String uname;

    public User(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String toString() {
        return "{" +
                "\"uid\":" + uid +
                ", \"uname\":\"" + uname + "\"" +
                "}";
    }
}
