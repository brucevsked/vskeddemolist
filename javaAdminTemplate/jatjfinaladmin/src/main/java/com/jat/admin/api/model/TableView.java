package com.jat.admin.api.model;

import java.util.LinkedList;
import java.util.List;

public class TableView {
    private int pageTotal=0;
    private List<?> list=new LinkedList<>();

    public TableView() {
    }

    public TableView(int pageTotal, List<?> list) {
        this.pageTotal = pageTotal;
        this.list = list;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
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
