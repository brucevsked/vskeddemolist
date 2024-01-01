package com.jat.demo12;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class User2RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User2RepositoryTest.class);

    @Resource
    User2Repository user2Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveUser(){
        Long user2Id1=1L;
        String user2Name1="新手";
        User2PO user2PO1=new User2PO(user2Id1,user2Name1);
        user2Repository.save(user2PO1);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveUserWithRole(){
        Long user2Id1=2L;
        String user2Name1="菜鸟";
        User2PO user2PO1=new User2PO(user2Id1,user2Name1);

        Long role2Id1=1002L;
        String role2Name1="法师";
        Role2PO role2PO1=new Role2PO(role2Id1,role2Name1);
        Long role2Id2=1003L;
        String role2Name2="战士";
        Role2PO role2PO2=new Role2PO(role2Id2,role2Name2);
        Long role2Id3=1004L;
        String role2Name3="道士";
        Role2PO role2PO3=new Role2PO(role2Id3,role2Name3);

        user2PO1.addRole(91234567002L,role2PO1);
        user2PO1.addRole(91234567003L,role2PO2);
        user2PO1.addRole(91234567004L,role2PO3);

        user2Repository.save(user2PO1);
    }

}
