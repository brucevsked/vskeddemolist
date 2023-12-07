package com.vsked.bookborrow.domain.valueobject;

/**
 * 自定义书籍编号
 */
public class BookNum {

    private String bookNum;

    public BookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookNum() {
        return bookNum;
    }
}
