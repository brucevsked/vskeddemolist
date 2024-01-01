package com.jat.demo9;

import com.jat.test.BaseTestWithTransactional;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

public class WebSiteRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(WebSiteRepositoryTest.class);

    @Resource
    WebSiteRepository webSiteRepository;

    @Resource
    EntityManager entityManager;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        long id=1L;
        String name="网站2";
        String url="http://www.a1.com";
        WebSiteEntity webSiteEntity=new WebSiteEntity(id,name,url);
        webSiteRepository.save(webSiteEntity);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createList(){
        for(int i=2;i<10;i++){
            long id=1L+i;
            String name="网站2"+i;
            String url="http://www.b"+i+".com";
            WebSiteEntity webSiteEntity=new WebSiteEntity(id,name,url);
            webSiteRepository.save(webSiteEntity);
        }

    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void delete(){
        long id=3L;
        webSiteRepository.deleteById(id);
        id=4L;
        webSiteRepository.deleteById(id);
        id=6L;
        webSiteRepository.deleteById(id);

        List<WebSiteEntity> webSiteEntityList=webSiteRepository.findAll();
        log.info("当前未删除数据数量为:{}",webSiteEntityList.size());
        log.info("当前未删除数据列表为:{}",webSiteEntityList);

    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void getDeleteList(){
        Boolean isDeleted=new Boolean(true);
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", isDeleted.booleanValue());
        List<WebSiteEntity> webSiteEntityDeletedList=webSiteRepository.findAll();
        session.disableFilter("deletedFilter");

        log.info("当前删除数据数量为:{}",webSiteEntityDeletedList.size());
        log.info("当前删除数据列表为:{}",webSiteEntityDeletedList);

        isDeleted=new Boolean(false);
        Session s1 = entityManager.unwrap(Session.class);
        Filter f1 = s1.enableFilter("deletedFilter");
        f1.setParameter("isDeleted", isDeleted.booleanValue());
        List<WebSiteEntity> webSiteEntityList=webSiteRepository.findAll();
        s1.disableFilter("deletedFilter");

        log.info("当前未删除数据数量为:{}",webSiteEntityList.size());
        log.info("当前未删除数据列表为:{}",webSiteEntityList);

    }




}
