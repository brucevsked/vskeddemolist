package com.vsked.bookborrow.infrastructure.repository.memory;
/*
import com.vsked.bookborrow.domain.aggregateroot.Book;
import com.vsked.bookborrow.domain.repository.BookRepository;
import com.vsked.bookborrow.domain.valueobject.BookId;

import java.util.*;

public class MemoryBookRepository implements BookRepository {

    private Set<Book> books;

    public MemoryBookRepository() {
        super();
        this.books=new HashSet<Book>();
    }

    @Override
    public void save(Book book) {
        Iterator<Book> bookIterator=books.iterator();
        Book bookTemp=null;
        boolean isExistBook=false;
        while (bookIterator.hasNext()){
            bookTemp=bookIterator.next();
            if(book.equals(bookTemp)){
                isExistBook=true;
            }
        }

        if(isExistBook==false){
            books.add(book);
        }
        //TODO is exist
        //books.containsKey(book)
    }

    @Override
    public void saveAll(Collection<Book> books) {

    }

    @Override
    public Book findById(BookId bookId) {
        return null;
    }

    @Override
    public void remove(Book book) {

    }

    @Override
    public void removeAll(Collection<Book> books) {

    }
}
*/