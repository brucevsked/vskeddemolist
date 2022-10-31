package com.jat.bo;

public class RoleId {
    private Long id;

    public Long getId() {
        return id;
    }

    public RoleId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("角色编号不能为空！");
        }
        this.id = id;
    }

    public String toString() {
        return "" +id ;
    }
}
