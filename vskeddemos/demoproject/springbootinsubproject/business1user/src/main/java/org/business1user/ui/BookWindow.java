package org.business1user.ui;

import org.business1user.service.BookService;
import org.business1user.service.dto.BookDTO;
import org.business1user.ui.vo.BookVO;

public interface BookWindow {

    void setBookService(BookService bookService);

    void saveBook(BookVO bookVO);

    BookDTO voToBookDTO(BookVO bookVO);
    BookVO dTOToBookVO(BookDTO bookDTO);
}
