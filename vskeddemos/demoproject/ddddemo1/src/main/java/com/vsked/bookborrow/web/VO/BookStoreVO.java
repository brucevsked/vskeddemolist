package com.vsked.bookborrow.web.VO;

import java.sql.Timestamp;

/**
 * 入库页面对象
 */
public class BookStoreVO {

    private Integer bookSeq;

    private Timestamp storageTime;

    private String bookNum;

    private String bookName;

    private String bookAuthor;

    public BookStoreVO() {
    }

    public BookStoreVO(Integer bookSeq, Timestamp storageTime, String bookNum, String bookName, String bookAuthor) {
        this.bookSeq = bookSeq;
        this.storageTime = storageTime;
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookSeq() {
        return bookSeq;
    }

    public void setBookSeq(Integer bookSeq) {
        this.bookSeq = bookSeq;
    }

    public Timestamp getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Timestamp storageTime) {
        this.storageTime = storageTime;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
