package com.jat.demo29;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("articleRepository1")
public interface ArticleRepository extends JpaRepository<Article1,Long> , JpaSpecificationExecutor<Article1> {

}
