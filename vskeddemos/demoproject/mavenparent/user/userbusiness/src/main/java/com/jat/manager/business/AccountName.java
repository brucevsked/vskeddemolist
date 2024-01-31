package com.jat.manager.business;

public class AccountName {

    private String name;

    public AccountName(String name) {
        if(name==null){
            throw new IllegalArgumentException("账户名不能为空，也不能重复，这是一个唯一标识");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
