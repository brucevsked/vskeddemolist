package com.jat.demo20;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class Permission5Record5RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Permission5Record5RepositoryTest.class);

    @Resource
    Permission5Record5Repository permission5Record5Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){

        Long pid=7000000L;
        String pname="权限名称测试";
        Permission5 p5=new Permission5(pid,pname);

        Long rid=80001L; //实际上是表中记录的编号
        Record5 r5=new Record5(rid);

        Long rTypeId=5L;//资源编号

        Permission5Record5 pr5=new Permission5Record5(rTypeId,p5,r5); //test ok1 推荐用此方案，表达更清楚

//        Permission5Record5PK prid=new Permission5Record5PK(pid,rid); //test ok2
//        Permission5Record5 pr5=new Permission5Record5(prid,rTypeId,pname); //test ok2
        permission5Record5Repository.save(pr5);
        log.debug("save ok");
    }

    @Test
    public void queryTest(){
        String pname="权限名称测试";
        Permission5Record5 pr5=permission5Record5Repository.findByPermission5Name(pname).orElse(null);
        log.debug("{}",pr5);
    }


}
