package com.vsked.system;

public class UserName {
    private String name;

    public UserName(String name) {
        if(name==null){
            throw new IllegalArgumentException("user name not be null！");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
