package com.jat.bo;

/**
 * 每页包括记录条数
 */
public class PageSize {

    private Integer size;

    public PageSize(Integer size) {
        if(size==null){
            size=new Integer(10);
        }
        if(size.intValue()<=0){
            size=new Integer(10);
        }
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public String toString() {
        return "" +size;
    }
}
