package com.jat.demo29;

import com.jat.test.BaseTestWithTransactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

public class ArticleRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(ArticleRepositoryTest.class);

    @Resource(name="articleRepository1")
    ArticleRepository articleRepository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
		Random r=new Random();
    	for(int i = 0;i<50;i++) {
    		Article1 article1 = new Article1(Long.valueOf(i+""),"title"+i,"作者"+r.nextInt(100),
					20+i,"this is my content"+r.nextInt(5000));
			articleRepository.save(article1);
    	}
    }
    
    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void query(){
		//推荐此方案
    	List<String> conditions = new LinkedList<String>();
    	conditions.add("title,title");
    	conditions.add("content,this is my conten");
    	conditions.add("author,65");
    	Page page = new Page();
    	page.setConditions(conditions);
    	
    	Specification<Article1> sp = new ArticleSpecification(page);
    	List<Article1> dataList = articleRepository.findAll(sp);
    	log.debug("{}",dataList);
    	
    }

	@Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
	@Test
	public void query2(){
		//不推荐此方案
		List<String> conditions = new LinkedList<String>();
		conditions.add("title,title");
		conditions.add("content,this is my conten");
		conditions.add("author,65");
		Page page = new Page();
		page.setConditions(conditions);

		Specification<Article1> sp = new Article2Specification(page);
		List<Article1> dataList = articleRepository.findAll(sp);
		log.debug("{}",dataList);

	}
}
