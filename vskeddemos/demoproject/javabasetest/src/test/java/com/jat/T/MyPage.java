package com.jat.T;

import java.util.List;

/**
 * 泛型测试1
 * @param <T>
 */
public class MyPage<T> {
    private int pageIndex;
    private int pageSize;
    private long total;
    private List<T> data;

    public void setTotal(long total) {
        this.total = total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public MyPage(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String toString() {
        return "{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
