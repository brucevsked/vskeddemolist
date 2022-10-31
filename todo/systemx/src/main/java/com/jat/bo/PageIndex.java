package com.jat.bo;

/**
 * 页面索引，也就是当前第几页
 */
public class PageIndex {

    /**
     * 当前页第一条数据的起始位置
     */
    private Integer index;

    public PageIndex(Integer index) {
        if(index==null){
            index=new Integer(0);
        }
        if(index.intValue()<=0){
            index=new Integer(0);
        }
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public String toString() {
        return "" + index;
    }
}
