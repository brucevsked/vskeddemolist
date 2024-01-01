package com.jat.demo11;

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

public class ActionParameterRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(ActionParameterRepositoryTest.class);

    @Resource
    ActionParameterRepository actionParameterRepository;

    @Resource
    EntityManager entityManager;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long id1=9001L;
        String name1=".login";
        ActionPO po1=new ActionPO(id1,name1);

        Long id2=1L;
        Integer sequence2=1;
        String type2="Long";
        String name2="bankUserCard";
        ParameterPO po2=new ParameterPO(id2,sequence2,type2,name2);

        Long id3=100000000000L;

        ActionParameterPO po=new ActionParameterPO(id3,po1,po2);
        actionParameterRepository.save(po);
        log.info("保存了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void getById(){
        Long actionId=9002L;
        Long parameterId=2L;
        ActionParameterPK pk=new ActionParameterPK(actionId,parameterId);
        ActionParameterPO po=actionParameterRepository.getById(pk);
        log.info("找到了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteTest(){
        Long actionId=9002L;
        Long parameterId=2L;
        ActionParameterPK pk=new ActionParameterPK(actionId,parameterId);
        ActionParameterPO po=actionParameterRepository.getById(pk);
        log.info("找到了:{}",po);
    }

    @Test
    public void getByDeletedFilter(){
        Boolean isDeleted=true;
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<ActionParameterPO> pos=actionParameterRepository.findAll();
        session.disableFilter("deletedFilter");
        log.info("当前删除的有:{}",pos);

    }


}
