package com.jat.repository.specific;

import com.jat.repository.model.ResourcePO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
