package com.jat.system.model.account;

public class AccountId {

    private final Integer id;

    public AccountId(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("账户编号不能为空！");
        }
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return "" + id;
    }
}
