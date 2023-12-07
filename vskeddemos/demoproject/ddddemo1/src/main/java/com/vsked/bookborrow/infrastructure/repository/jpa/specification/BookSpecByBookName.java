package com.vsked.bookborrow.infrastructure.repository.jpa.specification;

import com.vsked.bookborrow.domain.PO.BookPO;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 根据名称查询一个
 */
public class BookSpecByBookName implements Specification<BookPO> {

    private String bookName;

    public BookSpecByBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public Predicate toPredicate(Root<BookPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("bookName"), bookName);
    }

}
