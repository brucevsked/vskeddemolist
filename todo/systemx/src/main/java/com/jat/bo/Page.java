package com.jat.bo;

import java.util.LinkedList;
import java.util.List;

/**
 * 分页类
 */
public class Page<T> {

    /**
     * 当前第几页
     */
    private PageIndex currentPageIndex;
    /**
     * 第页显示多少条记录
     */
    private PageSize pageSize;

    /**
     * 一共有多少条记录
     */
    private PageTotalElementsNumber pageTotalElementsNumber;

    /**
     * 当前页数据
     */
    private List<T> data=new LinkedList<>();

    public Page(PageIndex currentPageIndex, PageSize pageSize) {
        this.currentPageIndex = currentPageIndex;
        this.pageSize = pageSize;
    }

    public PageIndex getCurrentPageIndex() {
        return currentPageIndex;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public PageTotalElementsNumber getPageTotalElementsNumber() {
        return pageTotalElementsNumber;
    }

    public List<T> getData() {
        return data;
    }

    public void setPageTotalElementsNumber(PageTotalElementsNumber pageTotalElementsNumber) {
        this.pageTotalElementsNumber = pageTotalElementsNumber;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String toString() {
        return "{" +
                "currentPageIndex=" + currentPageIndex +
                ", pageSize=" + pageSize +
                ", pageTotalElementsNumber=" + pageTotalElementsNumber +
                ", data=" + data +
                '}';
    }
}
