package com.vsked.page;

/**
 * total records number,also all records number
 */
public class VPageTotalElementsNumber {

    private Long total;

    public VPageTotalElementsNumber(Long total) {
        if(total==null){
            total= 0L;
        }
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

}
