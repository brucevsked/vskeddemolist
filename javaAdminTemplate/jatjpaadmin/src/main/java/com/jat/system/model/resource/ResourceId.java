package com.jat.system.model.resource;

public class ResourceId {

    private final Integer id;

    public ResourceId(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("资源编号不能为空！");
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
