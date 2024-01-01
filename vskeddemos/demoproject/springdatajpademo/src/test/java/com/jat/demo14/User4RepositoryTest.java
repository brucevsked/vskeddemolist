package com.jat.demo14;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class User4RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User4RepositoryTest.class);

    @Resource
    User4Repository user4Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.trace("save");
        Long userId1=1500000000L;
        String userName1="用户1";
        User4PO user1=new User4PO(userId1,userName1);
        user4Repository.save(user1);
        log.info("保存完成");
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveWithRole(){
        log.trace("saveWithRole");
        Set<Role4PO> roles=new HashSet<>();

        Long roleId1=1400000000L;
        String roleName1="超级管理员";
        Role4PO role1=new Role4PO(roleId1,roleName1);
        roles.add(role1);

        Long roleId2=1400000001L;
        String roleName2="普通用户";
        Role4PO role2=new Role4PO(roleId2,roleName2);
        roles.add(role2);
        Long roleId3=1400000002L;
        String roleName3="运营主管";
        Role4PO role3=new Role4PO(roleId3,roleName3);
        roles.add(role3);

        Long userId1=1500000001L;
        String userName1="用户2";
        User4PO user1=new User4PO(userId1,userName1,roles);
        user4Repository.save(user1);
        log.info("保存完成");
    }

    @Test
    public void query(){
        log.trace("query");
        Long userId1=1500000001L;
        Optional<User4PO> poo=user4Repository.findById(userId1);
        User4PO po=poo.get();
        log.info("找到对象:{}",po);
    }
}
