package com.vsked.bookborrow.infrastructure.repository.jpa.specification;

import com.vsked.bookborrow.domain.PO.BookPO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 根据名称查询多个
 */
public class BooksSpecByBookName implements Specification<BookPO> {

    private String bookName;

    public BooksSpecByBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public Predicate toPredicate(Root<BookPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("bookName"),"%"+bookName+"%");
    }

}
