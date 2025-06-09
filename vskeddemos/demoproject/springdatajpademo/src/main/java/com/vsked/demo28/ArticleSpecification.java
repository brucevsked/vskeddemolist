package com.vsked.demo28;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ArticleSpecification implements Specification<Article> {

	private static final long serialVersionUID = 724942245840058999L;
	private Page page;

	public ArticleSpecification(Page page) {
		this.page = page;
	}

	public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

		Predicate p1 = null;
		Predicate p2 = null;
		Predicate p3 = null;

		List<String> dataList = page.getConditions();
		if (isExistTitle(dataList)) {
			p1 = criteriaBuilder.like(root.get("title"), "%" + getTitle(dataList) + "%");
		}
		if (isExistContent(dataList)) {
			p2 = criteriaBuilder.like(root.get("content"), "%" + getContent(dataList) + "%");
		}
		if (isExistAuthor(dataList)) {
			p3 = criteriaBuilder.like(root.get("author"), "%" + getAuthor(dataList) + "%");
		}
		return criteriaBuilder.and(p1, p2, p3);

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
