package com.jat.demo12;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class UserRole2RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserRole2RepositoryTest.class);

    @Resource
    UserRole2Repository userRole2Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveUserRole2(){
        Long user2Id1=1L;
        String user2Name1="新手";
        User2PO user2PO1=new User2PO(user2Id1,user2Name1);

        Long role2Id1=1001L;
        String role2Name1="超级管理员";
        Role2PO role2PO1=new Role2PO(role2Id1,role2Name1);

        Long userRole2Id1=91234567001L;
        UserRole2PO userRole2PO1=new UserRole2PO(userRole2Id1,user2PO1,role2PO1);
        userRole2Repository.save(userRole2PO1);
    }
}
