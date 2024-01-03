package org.business1user.service;

import org.business1user.BookManager;
import org.business1user.business.Book;
import org.business1user.business.BookId;
import org.business1user.business.BookName;
import org.business1user.business.YellowBook;
import org.business1user.service.dto.BookDTO;
import org.business1user.service.dto.YellowBookDTO;

public class YellowBookService implements BookService{

    BookManager bookManager;

    @Override
    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Override
    public void save(BookDTO bookDTO) {
        Book yellowBook=DTOToBook(bookDTO);
        bookManager.createBook(yellowBook);
    }

    @Override
    public Book DTOToBook(BookDTO bookDTO) {
        BookId bookId=new BookId(bookDTO.getBookId());
        BookName bookName=new BookName(bookDTO.getBookName());
        Book yellowBook=new YellowBook(bookId,bookName);
        return yellowBook;
    }

    @Override
    public BookDTO bookToDTO(Book book) {
        BookDTO bookDTO=new YellowBookDTO(book.getBookId().getId(),book.getBookName().getName());
        return bookDTO;
    }

}
