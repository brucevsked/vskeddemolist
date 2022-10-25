package com.jat.bo;

public class PlatformUserId {

    private final Long id;

    public PlatformUserId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("用户编号不能为空！");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return "" + id;
    }
}
