package com.vsked.bookborrow.domain.valueobject;

/**
 * 书箱序号
 */
public class BookSeq {
    private Integer bookSeq;

    public BookSeq(Integer bookSeq) {
        this.bookSeq = bookSeq;
    }

    public Integer getBookSeq() {
        return bookSeq;
    }
}
