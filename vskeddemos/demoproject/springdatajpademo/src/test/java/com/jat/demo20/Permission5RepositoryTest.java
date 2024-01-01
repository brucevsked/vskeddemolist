package com.jat.demo20;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class Permission5RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Permission5RepositoryTest.class);

    @Resource
    Permission5Repository permission5Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long permission5Id=7000001L;
        String permission5Name="主体为权限测试a1";
        Permission5 permission5=new Permission5(permission5Id,permission5Name);

        Long record5Id=80002L;
        Record5 record5=new Record5(record5Id);

        Long typeId=6L;
        Permission5Record5 pr5=new Permission5Record5(typeId,permission5,record5); //test ok1 推荐用此方案，表达更清楚

        permission5.setPermissionRecord(pr5);
        permission5Repository.save(permission5);
    }

    @Test
    public void query(){
        Long pid=7000001L;
        Permission5 p5=permission5Repository.findById(pid).get();
        log.debug("permissionId:{}",p5.getId());
        log.debug("typeId:{}",p5.getPermissionRecord().getTypeId());
        log.debug("recordId:{}",p5.getPermissionRecord().getRecord5().getId());

    }
}
