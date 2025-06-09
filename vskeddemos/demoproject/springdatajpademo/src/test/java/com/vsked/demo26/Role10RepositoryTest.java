package com.vsked.demo26;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Optional;

public class Role10RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Role10RepositoryTest.class);

    @Resource
    Role10Repository role10Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.debug("init data");
        Role10 r1=new Role10(1L,"超级管理员");
        Role10 r2=new Role10(2L,"财务总监");
        Role10 r3=new Role10(3L,"运营总监");
        Role10 r4=new Role10(4L,"技术总监");
        Role10 r5=new Role10(5L,"员工");
        Role10 r6=new Role10(6L,"超级管理员");
        role10Repository.save(r1);
        role10Repository.save(r2);
        role10Repository.save(r3);
        role10Repository.save(r4);
        role10Repository.save(r5);
        role10Repository.save(r6);
    }

    @Test
    public void query1(){
        Long id=1L;
        String name="超级管理员";

        Optional<Role10> resultRole=role10Repository.findAllByIdNotAndNameIs(id,name);
        Role10 r1=resultRole.get();
        log.debug("长版本方案1：{}",r1);

        Role10 myRole=role10Repository.findByIdNotAndNameIs(id,name);
        log.debug("短版本方案2：{}",myRole);


    }

}
