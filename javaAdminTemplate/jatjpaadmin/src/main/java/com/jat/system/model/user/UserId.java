package com.jat.system.model.user;

public class UserId {

    private final Integer id;

    public UserId(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("用户编号不能为空！");
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
