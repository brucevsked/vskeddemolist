package org.business1user;

import org.business1user.business.Book;
import org.business1user.repository.BookRepository;
import org.business1user.repository.entity.BookEntity;

public interface BookManager {

    void setBookRepository(BookRepository bookRepository);

    void createBook(Book book);

    BookEntity bookToEntity(Book book);

    Book entityToBook(BookEntity bookEntity);

}
