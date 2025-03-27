package com.jat.exam.model;

/**
 * 编号
 */
public class Id {
    private Integer id;

    public Id(Integer id,String type) {
        if(id==null){
            throw new IllegalArgumentException(type+"编号不能为空！");
        }
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return id+"";
    }
}
