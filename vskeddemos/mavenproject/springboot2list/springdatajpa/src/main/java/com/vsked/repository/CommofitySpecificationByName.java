package com.vsked.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vsked.entity.Commodity;

public class CommofitySpecificationByName implements Specification<Commodity>{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public CommofitySpecificationByName(String name) {
		super();
		this.name = name;
	}

	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
	    return criteriaBuilder.equal(root.get("name"), name);
	}

}
