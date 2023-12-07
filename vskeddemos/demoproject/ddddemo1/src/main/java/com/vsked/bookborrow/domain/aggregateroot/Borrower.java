package com.vsked.bookborrow.domain.aggregateroot;

import com.vsked.bookborrow.domain.valueobject.BorrowerId;
import com.vsked.bookborrow.domain.valueobject.BorrowerName;

import java.util.ArrayList;
import java.util.List;

public class Borrower {

    private BorrowerId borrowerId;
    private BorrowerName borrowerName;
    private List<Book> borrowList;
    private List<Book> returnList;

    public List<Book> getBorrowList(){
        //TODO from db
        return new ArrayList<Book>();
    }

    public List<Book> getReturnList(){
        //TODO from db
        return new ArrayList<Book>();
    }

    public void borrowBook(Book book){
        getBorrowList().add(book);
    }

    public void returnBook(Book book){
        getReturnList().add(book);
    }

}
