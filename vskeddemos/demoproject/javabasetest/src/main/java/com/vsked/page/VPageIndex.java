package com.vsked.page;

/**
 * pageIndex,also current page number
 */
public class VPageIndex {
    /**
     * start index at current page
     */
    private Integer index;

    public VPageIndex(Integer index) {
        if(index==null){
            index= 0;
        }
        if(index <=0){
            index= 0;
        }
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

}
