package org.business1user.ui;

import org.business1user.service.BookService;
import org.business1user.service.dto.BookDTO;
import org.business1user.service.dto.YellowBookDTO;
import org.business1user.ui.vo.BookVO;
import org.business1user.ui.vo.YellowBookVO;

public class YellowBookWindow implements BookWindow{

    BookService bookService;

    @Override
    public void setBookService(BookService bookService) {
        this.bookService=bookService;
    }

    @Override
    public void saveBook(BookVO bookVO) {
        BookDTO bookDTO=voToBookDTO(bookVO);
        bookService.save(bookDTO);
    }

    @Override
    public BookDTO voToBookDTO(BookVO bookVO) {
        BookDTO bookDTO=new YellowBookDTO(bookVO.getBookId(),bookVO.getBookName());
        return bookDTO;
    }

    @Override
    public BookVO dTOToBookVO(BookDTO bookDTO) {
        BookVO bookVO=new YellowBookVO(bookDTO.getBookId(),bookDTO.getBookName());
        return bookVO;
    }
}
