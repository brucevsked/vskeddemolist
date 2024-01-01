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

public class ActionRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(ActionRepositoryTest.class);

    @Resource
    ActionRepository actionRepository;

    @Resource
    EntityManager entityManager;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long id=9001L;
        String name=".login";
        ActionPO po=new ActionPO(id,name);
        actionRepository.save(po);
        log.info("保存了:{}",po);

    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveWithParameter(){
        Long parameterId1=2L;
        Integer parameterSequence1=1;
        String parameterType1="String";
        String parameterName1="uname";
        ParameterPO parameter1=new ParameterPO(parameterId1,parameterSequence1,parameterType1,parameterName1);

        Long parameterId2=3L;
        Integer parameterSequence2=2;
        String parameterType2="Integer";
        String parameterName2="69";
        ParameterPO parameter2=new ParameterPO(parameterId2,parameterSequence2,parameterType2,parameterName2);

        Long actionId1=9002L;
        String actionName1=".test";
        ActionPO action1=new ActionPO(actionId1,actionName1);

        Long actionParameterId1=100000000001L;
        action1.addParameter(parameter1,actionParameterId1);
        Long actionParameterId2=100000000002L;
        action1.addParameter(parameter2,actionParameterId2);

        actionRepository.save(action1);

        log.info("保存了:{}",action1);


    }

    @Test
    public void findAll(){
        List<ActionPO> actions=actionRepository.findAll();
        log.info("当前所有:{}",actions);
    }

    @Test
    public void findAllByDeletedFilter1(){
        Boolean isDeleted=false;
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<ActionPO> actions=actionRepository.findAll();
        session.disableFilter("deletedFilter");
        log.info("当前所有:{}",actions);
    }


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void getById(){
        Long id=9002L;
        ActionPO po=actionRepository.getById(id);
        log.info("找到了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void delete1ParameterTest(){
        Long id=9002L;
        Long parameterId2=3L;
        ActionPO po=actionRepository.getById(id);
        log.info("找到:{}",po);
        po.removeParameter(parameterId2);
        actionRepository.save(po);
        log.info("保存了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void restore1ParameterTest(){
        Long id=9002L;
        Long parameterId2=3L;
        ActionPO po=actionRepository.getById(id);
        log.info("找到:{}",po);
        po.restoreParameter(parameterId2);
        actionRepository.save(po);
        log.info("保存了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteAllParameterTest(){
        Long id=9002L;
        ActionPO po=actionRepository.getById(id);
        po.removeAllParameter();
        actionRepository.save(po);
        log.info("保存了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void restoreAllParameterTest(){
        Long id=9002L;
        ActionPO po=actionRepository.getById(id);
        log.info("找到:{}",po);
        po.restoreAllParameter();
        actionRepository.save(po);
        log.info("保存了:{}",po);
    }


}
