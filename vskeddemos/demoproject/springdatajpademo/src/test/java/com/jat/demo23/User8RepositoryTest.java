package com.jat.demo23;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class User8RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User8RepositoryTest.class);

    @Resource
    User8Repository user8Repository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void cascadeAdd(){
        //级联新增
        Set<Certificate8PO> certificates=new HashSet<>();
        Certificate8PO certificate1=new Certificate8PO(1L,"ok1");
        Certificate8PO certificate2=new Certificate8PO(2L,"no1");
        certificates.add(certificate1);
        certificates.add(certificate2);
        User8PO user1=new User8PO(101L,"user11",certificates);
        user8Repository.save(user1);

        User8PO userStored=user8Repository.getById(101L);
        log.debug("{}",userStored);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void cascadeDelete(){
        //级联新增
        Set<Certificate8PO> certificates=new HashSet<>();
        Certificate8PO certificate1=new Certificate8PO(1L,"ok1");
        Certificate8PO certificate2=new Certificate8PO(2L,"no1");
        Certificate8PO certificate3=new Certificate8PO(3L,"a1");
        Certificate8PO certificate4=new Certificate8PO(4L,"b1");
        Certificate8PO certificate5=new Certificate8PO(5L,"c1");
        Certificate8PO certificate6=new Certificate8PO(6L,"d1");
        certificates.add(certificate1);
        certificates.add(certificate2);
        certificates.add(certificate3);
        certificates.add(certificate4);
        certificates.add(certificate5);
        certificates.add(certificate6);
        User8PO user1=new User8PO(101L,"user11",certificates);
        user8Repository.save(user1);

        User8PO userStored=user8Repository.getById(101L);
        log.debug("{}",userStored);

        certificates.remove(certificate1); //删除几个
        certificates.remove(certificate2);
        certificates.remove(certificate3);

        user1=new User8PO(101L,"user11",certificates);
        user8Repository.save(user1);//测试级联删除

        userStored=user8Repository.getById(101L);
        log.debug("{}",userStored);

    }
}
