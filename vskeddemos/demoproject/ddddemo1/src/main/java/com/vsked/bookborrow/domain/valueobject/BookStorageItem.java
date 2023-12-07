package com.vsked.bookborrow.domain.valueobject;

import com.vsked.bookborrow.domain.aggregateroot.Book;

import java.sql.Timestamp;

/**
 *图书入库选项(行)
 */
public class BookStorageItem {

    /**
     * 图书入库表序号从1开始递增
     */
    private Integer serialNumber;

    /**
     * 入库时间
     */
    private Timestamp storageTime;

    /**
     * 图书
     */
    private Book book;

    public BookStorageItem(Integer serialNumber, Timestamp storageTime, Book book) {
        this.serialNumber = serialNumber;
        this.storageTime = storageTime;
        this.book = book;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public Timestamp getStorageTime() {
        return storageTime;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "BookStoreItem{" +
                "serialNumber=" + serialNumber +
                ", storageTime=" + storageTime +
                ", book=" + book.toString()+
                '}';
    }
}
