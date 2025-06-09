package com.vsked.demo25;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class User10RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User10RepositoryTest.class);

    @Resource
    User10Repository user10Repository;
    @Resource
    Certificate10PORepository certificate10PORepository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteCascade(){
        log.debug("start delete ");

        Certificate10PO c1=new Certificate10PO(1L,"aa1");
        Certificate10PO c2=new Certificate10PO(2L,"aa2");
        Certificate10PO c3=new Certificate10PO(3L,"aa3");
        Certificate10PO c4=new Certificate10PO(4L,"aa4");
        Certificate10PO c5=new Certificate10PO(5L,"aa5");
        Certificate10PO c6=new Certificate10PO(6L,"aa6");

        Set<Certificate10PO> cs=new HashSet<>();
        cs.add(c1);
        cs.add(c2);
        cs.add(c3);
        cs.add(c4);
        cs.add(c5);
        cs.add(c6);

        Long uid=101L;
        User10PO user=new User10PO(uid,"goodname",cs);
        user10Repository.save(user);//第一次初始化数据
        log.debug("{}",user);

        cs.remove(c3);
        cs.remove(c4);
        cs.remove(c5);
        cs.remove(c6);

        user.setCertificate(cs); //删除后

        log.debug("{}",user);

        user10Repository.save(user);//重新保存 只会删除中间表,不会清除实体表

        Set<Long> deleteIds=new HashSet<>();
        deleteIds.add(c6.getId());
        deleteIds.add(c5.getId());
        deleteIds.add(c4.getId());
        deleteIds.add(c3.getId());

        certificate10PORepository.deleteAllByIdInBatch(deleteIds);//清理实体表信息

        user=user10Repository.getById(uid);

        log.debug("{}",user);
    }
}
