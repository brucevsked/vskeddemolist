package com.vsked.demo29;

import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ArticleSpecification implements Specification<Article1> {

	private Page page;

	public ArticleSpecification(Page page) {
		this.page = page;
	}
    
	public Predicate toPredicate(Root<Article1> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

		Predicate predicate = cb.conjunction();

		List<String> dataList = page.getConditions();
		if (isExistTitle(dataList)) {
			predicate.getExpressions().add(cb.like(root.get("title").as(String.class), "%" + getTitle(dataList) + "%"));
		}
		if (isExistContent(dataList)) {
			predicate.getExpressions().add(cb.like(root.get("content").as(String.class), "%" + getContent(dataList) + "%"));
		}
		if (isExistAuthor(dataList)) {
			predicate.getExpressions().add(cb.like(root.get("author").as(String.class), "%" + getAuthor(dataList) + "%"));
		}
		return predicate;

	}


	// "key,value"
	public Boolean isExistTitle(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("title,")) {
				return true;
			}
		}
		return false;
	}

	public String getTitle(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("title,")) {
				return s.split(",")[1];
			}
		}
		return "";
	}

	public Boolean isExistContent(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("content,")) {
				return true;
			}
		}
		return false;
	}

	public String getContent(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("content,")) {
				return s.split(",")[1];
			}
		}
		return "";
	}

	public Boolean isExistAuthor(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("author,")) {
				return true;
			}
		}
		return false;
	}

	public String getAuthor(List<String> dateList) {
		for (String s : dateList) {
			if (s.startsWith("author,")) {
				return s.split(",")[1];
			}
		}
		return "";
	}
}
