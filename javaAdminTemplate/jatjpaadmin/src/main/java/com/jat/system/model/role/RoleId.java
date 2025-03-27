package com.jat.system.model.role;

public class RoleId {

    private final Integer id;

    public RoleId(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("角色编号不能为空！");
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
