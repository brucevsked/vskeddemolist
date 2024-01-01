package com.jat.demo29;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class Article2Specification implements Specification<Article1> {

	private static final long serialVersionUID = 724942245840058999L;
	private Page page;

	public Article2Specification(Page page) {
		this.page = page;
	}
    
	public Predicate toPredicate(Root<Article1> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new LinkedList<>();

		List<String> dataList = page.getConditions();
		if (isExistTitle(dataList)) {
			Predicate p1=criteriaBuilder.like(root.get("title"), "%" + getTitle(dataList) + "%");
			predicates.add(p1);
		}
		if (isExistContent(dataList)) {
			Predicate p2 = criteriaBuilder.like(root.get("content"), "%" + getContent(dataList) + "%");
			predicates.add(p2);
		}
		if (isExistAuthor(dataList)) {
			Predicate p3 = criteriaBuilder.like(root.get("author"), "%" + getAuthor(dataList) + "%");
			predicates.add(p3);
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

	}

	/**
	 *
	 方案2 动态and或or拼接

	 public class ResourceListSpecific implements Specification<ResourcePO> {

	 private Map<String,Object> params;

	 public ResourceListSpecific(Map<String, Object> params) {
	 this.params = params;
	 }

	 @Override
	 public Predicate toPredicate(Root<ResourcePO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	 List<Predicate> ps=new LinkedList<>();
	 //and 1=1处理
	 Predicate pall=criteriaBuilder.equal(criteriaBuilder.literal(1),1);
	 if(params.get("name")!=null && (!"".equals(params.get("name"))) ){
	 String uname="%"+params.get("name")+"%";
	 Predicate p1 = criteriaBuilder.like(root.get("name"), uname);
	 pall=criteriaBuilder.and(pall,p1);
	 }

	 if(params.get("url")!=null){
	 String url="%"+params.get("url")+"%";
	 Predicate p1 = criteriaBuilder.like(root.get("url"), url);
	 pall=criteriaBuilder.and(pall,p1);
	 }

	 if(params.get("isDel")!=null){
	 Predicate p1 = criteriaBuilder.equal(root.get("isDel"), params.get("isDel"));
	 pall=criteriaBuilder.and(pall,p1);
	 }

	 if(params.get("parentName")!=null ){
	 String uname="%"+params.get("parentName")+"%";
	 Predicate p1 = criteriaBuilder.like(root.join("parent", JoinType.LEFT).get("name"), uname);
	 String parentName=params.get("parentName")+"";
	 if(parentName.length()<=0){
	 Predicate p2 = criteriaBuilder.isNull(root.join("parent", JoinType.LEFT).get("name"));
	 Predicate p3=criteriaBuilder.or(p1,p2);
	 pall=criteriaBuilder.and(pall,p3);
	 }
	 pall=criteriaBuilder.and(pall,p1);
	 }

	 return pall;
	 }
	 }



	 */



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
