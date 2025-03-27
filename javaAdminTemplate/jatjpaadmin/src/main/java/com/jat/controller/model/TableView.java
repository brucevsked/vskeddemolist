package com.jat.controller.model;

import java.util.LinkedList;
import java.util.List;

public class TableView {
    private long pageTotal=0;
    private List<?> list=new LinkedList<>();

    public TableView() {
    }

    public TableView(long pageTotal, List<?> list) {
        this.pageTotal = pageTotal;
        this.list = list;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String toString() {
        return "{" +
                "\"pageTotal\":" + pageTotal +
                ", \"list\":" + list +
                '}';
    }
}
