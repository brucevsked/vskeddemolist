package org.business1user.business;

public class YellowBook implements Book{

    private BookId bookId;
    private BookName bookName;

    public YellowBook(BookId bookId, BookName bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public BookId getBookId() {
        return bookId;
    }

    public BookName getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "YellowBook{" +
                "bookId=" + bookId +
                ", bookName=" + bookName +
                '}';
    }
}
