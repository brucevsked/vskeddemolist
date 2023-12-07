package com.vsked.bookborrow.web.VO;

/**
 * 从页面上传过来的对象
 */
public class BookVO {

    private Long bookId;

    private String bookName;

    private boolean bookBorrowStatus;

    private boolean bookOnShelfStatus;

    public BookVO() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isBookBorrowStatus() {
        return bookBorrowStatus;
    }

    public void setBookBorrowStatus(boolean bookBorrowStatus) {
        this.bookBorrowStatus = bookBorrowStatus;
    }

    public boolean isBookOnShelfStatus() {
        return bookOnShelfStatus;
    }

    public void setBookOnShelfStatus(boolean bookOnShelfStatus) {
        this.bookOnShelfStatus = bookOnShelfStatus;
    }

    public BookVO(Long bookId, String bookName, boolean bookBorrowStatus, boolean bookOnShelfStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookBorrowStatus = bookBorrowStatus;
        this.bookOnShelfStatus = bookOnShelfStatus;
    }
}
