package com.vsked.bookborrow.domain.valueobject;

/**
 * 书箱分类
 */
public class BookCatagory {

    /**
     * 书籍分类名称
     */
    private String bookCatagoryName;

    public BookCatagory(String bookCatagoryName) {
        this.bookCatagoryName = bookCatagoryName;
    }

    public String getBookCatagoryName() {
        return bookCatagoryName;
    }
}
