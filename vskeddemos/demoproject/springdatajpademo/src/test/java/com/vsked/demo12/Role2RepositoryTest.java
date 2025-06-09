package com.vsked.demo12;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class Role2RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Role2RepositoryTest.class);

    @Resource
    Role2Repository role2Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveRole(){
        Long role2Id1=1001L;
        String role2Name1="超级管理员";
        Role2PO role2PO1=new Role2PO(role2Id1,role2Name1);
        role2Repository.save(role2PO1);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveRoleWithUser(){

        Long user2Id1=3L;
        String user2Name1="刘备";
        User2PO user2PO1=new User2PO(user2Id1,user2Name1);

        Long user2Id2=4L;
        String user2Name2="张飞";
        User2PO user2PO2=new User2PO(user2Id2,user2Name2);

        Long user2Id3=5L;
        String user2Name3="关羽";
        User2PO user2PO3=new User2PO(user2Id3,user2Name3);

        Long role2Id1=1005L;
        String role2Name1="宇宙维修工";
        Role2PO role2PO1=new Role2PO(role2Id1,role2Name1);

        role2PO1.addUser(91234567005L,user2PO1);
        role2PO1.addUser(91234567006L,user2PO2);
        role2PO1.addUser(91234567007L,user2PO3);
        role2Repository.save(role2PO1);
    }

}
