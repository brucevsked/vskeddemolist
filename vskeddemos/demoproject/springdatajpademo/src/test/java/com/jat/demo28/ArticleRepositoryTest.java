package com.jat.demo28;

import com.jat.test.BaseTestWithTransactional;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;


public class ArticleRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(ArticleRepositoryTest.class);

    @Resource
    ArticleRepository articleRepository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
    	for(int i = 0;i<50;i++) {
    		Article article = new Article(new Long(i),"title"+i,"作者"+i,20+i,"asdfgwr"+i);
    		articleRepository.save(article);
    	}
    	
    }
    
    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void query(){
    	List<String> conditions = new LinkedList<String>();
    	conditions.add("title,t");
    	conditions.add("content,123456");
    	conditions.add("author,uhygug");
    	Page page = new Page();
    	page.setConditions(conditions);
    	
    	Specification<Article> sp = new ArticleSpecification(page);
    	List<Article> dataList = articleRepository.findAll(sp);
    	log.debug("{}",dataList);
    	
    }

}
