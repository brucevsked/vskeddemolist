package org.business1user.service;

import org.business1user.BookManager;
import org.business1user.business.Book;
import org.business1user.service.dto.BookDTO;

public interface BookService {

    void setBookManager(BookManager bookManager);
    void save(BookDTO bookDTO);

    Book DTOToBook(BookDTO bookDTO);
    BookDTO bookToDTO(Book book);

}
