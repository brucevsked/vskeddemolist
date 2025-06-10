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
        user.put("uid","2");
        user.put("uname","useraaaaaa");
        user.put("upass","passbbbb");
        user.put("ubirth","1988-03-02");
        userDao.insertUser(user);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void insertBatch(){
        List<Map<String,Object>> userList=new LinkedList<>();

        for(int i=0;i<100;i++){
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

    @Rollback(value = false) //事务不回滚
    @Test
    public void updateBatch(){
        List<Map<String,Object>> userList=new LinkedList<>();

        for(int i=0;i<100;i++){
            Map<String,Object> user=new HashMap<>();
            user.put("uid","1"+i);
            user.put("upass","passzzzzzzzzz1"+i);
            userList.add(user);
        }

        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("myList",userList);

        int row=userDao.updateUsers(dataMap);
        log.debug("{}",row);
    }

    @Test
    public void getUserById(){
        Map<String,Object> user=userDao.getUserById(2L);
        log.debug("{}",user);
    }

    @Test
    public void listvsked(){
        Map<String,Object> parMap=new HashMap<>();
        parMap.put("sql","select * from users");
        List<Map<String,Object>> dataList=userDao.listvsked(parMap);
        log.debug("{}",dataList);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void list1vsked(){
        Map<String,Object> parMap=new HashMap<>();
        parMap.put("sql","insert into users values(55,'mynameisvsked','password',null)");
        List<Map<String,Object>> dataList=userDao.listvsked(parMap);
        log.debug("{}",dataList);
    }
}
