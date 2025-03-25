package com.vsked.test;

public class UserEntity {

    private Long uid;
    private String uname;

    public UserEntity() {
    }

    public UserEntity(Long uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
