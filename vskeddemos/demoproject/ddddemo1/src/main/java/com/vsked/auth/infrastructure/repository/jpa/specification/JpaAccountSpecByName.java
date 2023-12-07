package com.vsked.auth.infrastructure.repository.jpa.specification;

import com.vsked.auth.domain.PO.AccountPO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JpaAccountSpecByName implements Specification<AccountPO> {

    private String accountName;

    public JpaAccountSpecByName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public Predicate toPredicate(Root<AccountPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.equal(root.get("accountName"),accountName);
    }
}
