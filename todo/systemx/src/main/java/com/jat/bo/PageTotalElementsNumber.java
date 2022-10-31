package com.jat.bo;

/**
 * 总记录条数，也就是一共有多少条记录
 */
public class PageTotalElementsNumber {

    private Long total;

    public PageTotalElementsNumber(Long total) {
        if(total==null){
            total=new Long(0);
        }
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public String toString() {
        return "" +total;
    }
}
