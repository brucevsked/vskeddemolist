package com.jat.bo;

public class PlatformAccountId {

    private final Long id;

    public PlatformAccountId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("账户编号不能为空！");
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
