package com.jat.page;

import java.util.LinkedList;
import java.util.List;

public class VPage<T> {
	   /**
     * current page
     */
    private VPageIndex currentVPageIndex;
    /**
     * records in per page
     */
    private VPageSize VPageSize;

    /**
     * all records number
     */
    private VPageTotalElementsNumber VPageTotalElementsNumber;

    /**
     * current page data
     */
    private List<T> data=new LinkedList<>();
    
    /**
     * query condition value
     */
    List<VQueryCondition> conditions = new LinkedList<VQueryCondition>();

    public VPage(VPageIndex currentVPageIndex, VPageSize VPageSize) {
        this.currentVPageIndex = currentVPageIndex;
        this.VPageSize = VPageSize;
    }

    public VPageIndex getCurrentPageIndex() {
        return currentVPageIndex;
    }

    public VPageSize getPageSize() {
        return VPageSize;
    }

    public VPageTotalElementsNumber getPageTotalElementsNumber() {
        return VPageTotalElementsNumber;
    }

    public List<T> getData() {
        return data;
    }

    public void setPageTotalElementsNumber(VPageTotalElementsNumber VPageTotalElementsNumber) {
        this.VPageTotalElementsNumber = VPageTotalElementsNumber;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
    public List<VQueryCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<VQueryCondition> conditions) {
		this.conditions = conditions;
	}

}
