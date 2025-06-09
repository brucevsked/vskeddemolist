package com.vsked.demo14;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Optional;

public class Permission4RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Permission4RepositoryTest.class);

    @Resource
    Permission4Repository permission4Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.trace("保存权限");
        Long permissionId1=1300000004L;
        String permissionName1="注册权限";
        Permission4PO permission1=new Permission4PO(permissionId1,permissionName1);
        permission4Repository.save(permission1);
    }

    @Test
    public void query(){
        log.trace("query");
        Long permissionId1=1300000001L;
        Optional<Permission4PO> poo=permission4Repository.findById(permissionId1);
        Permission4PO po=poo.get();
        log.info("找到对象:{}",po);
    }
}
