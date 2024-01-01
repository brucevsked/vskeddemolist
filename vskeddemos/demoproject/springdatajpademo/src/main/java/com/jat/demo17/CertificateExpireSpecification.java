package com.jat.demo17;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class CertificateExpireSpecification implements Specification<User6> {

    private Date expireTime;

    public CertificateExpireSpecification(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public Predicate toPredicate(Root<User6> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        return cb.greaterThan(
                root.join("certificates",JoinType.LEFT).get("expireTime"),
                expireTime);
    }
}
