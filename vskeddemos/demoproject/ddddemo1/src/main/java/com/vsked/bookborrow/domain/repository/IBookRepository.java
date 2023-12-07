package com.vsked.bookborrow.domain.repository;

import com.vsked.bookborrow.domain.PO.BookPO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IBookRepository {

    /**
     * 查询一本书
     * @param spec
     * @return
     */
    BookPO findOne(Specification<BookPO> spec);

    /**
     * 查询符合条件的多本书
     * @param spec
     * @return
     */
    List<BookPO> find(Specification<BookPO> spec);

    /**
     * 删除一本书
     * @param bookPO
     */
    void delete(BookPO bookPO);

}
