package com.vsked.system;

public class AccountName {
    private String name;

    public AccountName(String name) {
        if(name==null){
            throw new IllegalArgumentException("account name not be null！");
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
