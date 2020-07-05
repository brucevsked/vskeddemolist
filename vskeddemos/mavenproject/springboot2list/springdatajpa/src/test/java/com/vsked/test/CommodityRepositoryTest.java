package com.vsked.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.vsked.entity.Commodity;
import com.vsked.repository.CommodityRepository;
import com.vsked.repository.CommofitySpecificationByName;

public class CommodityRepositoryTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(CommodityRepositoryTest.class);
	
	@Autowired
	CommodityRepository commodityRepository;
	
//	@Test
	public void test1() {
		String myName="apple";
		Specification<Commodity> specification = new Specification<Commodity>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
			    return criteriaBuilder.like(root.get("name"), myName);
			   }
			  };
	    Commodity commodity=commodityRepository.findOne(specification).get();
		log.debug("query ok"+commodity.getPrice());
	}
	
	@Test
	public void test2() {
		String myName="apple";
		Specification<Commodity> specification=new CommofitySpecificationByName(myName);
	    Commodity commodity=commodityRepository.findOne(specification).get();
		log.debug("query ok"+commodity.getPrice());
	}
	
}
