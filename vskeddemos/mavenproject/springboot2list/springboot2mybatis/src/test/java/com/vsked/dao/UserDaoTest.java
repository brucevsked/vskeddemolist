package com.vsked.dao;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDaoTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    UserDao userDao;

    @Rollback(value = false) //事务不回滚
    @Test
    public void insert(){
        Map<String,Object> user=new HashMap<>();
        user.put("uid","1");
        user.put("uname","user1");
        user.put("upass","pass1");
        user.put("ubirth","1988-03-02");
        userDao.insertUser(user);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void insertBatch(){
        List<Map<String,Object>> userList=new LinkedList<>();

        for(int i=0;i<100000;i++){
            Map<String,Object> user=new HashMap<>();
            user.put("uid","1"+i);
            user.put("uname","user1"+i);
            user.put("upass","pass1"+i);
            user.put("ubirth","1988-03-02");
            userList.add(user);
        }

        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("myList",userList);

        int row=userDao.insertUsers(dataMap);
        log.debug("{}",row);
    }
}
