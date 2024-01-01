package com.jat.demo4;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public class AccountSpecificationByName implements Specification<AccountEntity>{

	private static final long serialVersionUID = 6618976997262383865L;
	
	private String accountName;
	
	public AccountSpecificationByName(String accountName) {
		this.accountName = accountName;
	}

	public Predicate toPredicate(Root<AccountEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
	    return criteriaBuilder.equal(root.get("accountName"), accountName);
	}

}
