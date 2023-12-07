package com.vsked.bookborrow.domain.factory;

import com.vsked.bookborrow.domain.PO.BookPO;
import com.vsked.bookborrow.domain.aggregateroot.Book;
import com.vsked.bookborrow.domain.valueobject.BookId;
import com.vsked.bookborrow.domain.valueobject.BookName;
import com.vsked.bookborrow.web.VO.BookVO;

import java.util.LinkedList;
import java.util.List;

public class BookFactory {


    /**
     * 将数据库对象转换为领域模型(PO to domain Entity)
     * @return
     */
    public static Book createBookFromPO(BookPO bookPO){
        BookId bookId=new BookId(bookPO.getBookId());
        BookName bookName=new BookName(bookPO.getBookName());
        boolean bookBorrowStatus=bookPO.isBookBorrowStatus();
        boolean bookOnShelfStatus=bookPO.isBookOnShelfStatus();
        //return new Book(bookId,bookName,bookBorrowStatus,bookOnShelfStatus);
        //TODO will fixed
        return null;
    }

    /**
     * 将页面对象转换为领域模型(VO to domain Entity)
     * @param bookVO
     * @return
     */
    public static Book createBookFromVO(BookVO bookVO){
        BookId bookId=new BookId(bookVO.getBookId());
        BookName bookName=new BookName(bookVO.getBookName());
        boolean bookBorrowStatus=bookVO.isBookBorrowStatus();
        boolean bookOnShelfStatus=bookVO.isBookOnShelfStatus();
        //return new Book(bookId,bookName,bookBorrowStatus,bookOnShelfStatus);

        //TODO fixed
        return null;
    }



    /**
     * 批量将数据库对象转换为领域模型
     * @param books
     * @return
     */
    public static List<Book> createBooks(List<BookPO> books){
        List<Book> myBooks=new LinkedList<Book>();
        for(BookPO book:books){
            myBooks.add(BookFactory.createBookFromPO(book));
        }
        return myBooks;
    }
}
