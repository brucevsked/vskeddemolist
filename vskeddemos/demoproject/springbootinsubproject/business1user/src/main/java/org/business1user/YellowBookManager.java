package org.business1user;

import org.business1user.business.Book;
import org.business1user.business.BookId;
import org.business1user.business.BookName;
import org.business1user.business.YellowBook;
import org.business1user.repository.BookRepository;
import org.business1user.repository.entity.BookEntity;
import org.business1user.repository.entity.YellowBookEntity;

public class YellowBookManager implements BookManager{

    private BookRepository bookRepository;

    /**
     * 在这里注入
     * @param bookRepository
     */
    @Override
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book){
        BookEntity bookEntity=bookToEntity(book);
        bookRepository.save(bookEntity);
    }


    public BookEntity bookToEntity(Book book){
        BookEntity bookEntity=new YellowBookEntity(book.getBookId().getId(),book.getBookName().getName());
        return bookEntity;
    }

    @Override
    public Book entityToBook(BookEntity bookEntity) {
        BookId bookId=new BookId(bookEntity.getBookId());
        BookName bookName=new BookName(bookEntity.getBookName());
        Book yellowBook=new YellowBook(bookId,bookName);
        return yellowBook;
    }
}
