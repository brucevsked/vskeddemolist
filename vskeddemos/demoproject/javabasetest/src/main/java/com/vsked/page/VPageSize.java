package com.vsked.page;

/**
 * records in per page
 */
public class VPageSize {

    private Integer size;

    public VPageSize(Integer size) {
        if(size==null){
            size= 10;
        }
        if(size <=0){
            size= 10;
        }
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

}
