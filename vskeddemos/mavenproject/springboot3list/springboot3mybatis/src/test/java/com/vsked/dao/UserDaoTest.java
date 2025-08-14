package com.vsked.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vsked.test.BaseTestWithTransactional;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
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
        Map<String,Object> user=userDao.getUserById(12L);
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

    @Test
    public void pageTest(){
        int pageNum = 1;
        int pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> users = userDao.findAll(); // 查询后自动分页
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(users); // 获取分页信息 包括总条数，总页数，每页条数，当前页等信息
        log.debug("{}",pageInfo); // 打印分页信息
        //PageInfo{pageNum=1, pageSize=10, size=10, startRow=1, endRow=10, total=100, pages=10, list=Page{count=true, pageNum=1, pageSize=10, startRow=0, endRow=10, total=100, pages=10, reasonable=false, pageSizeZero=false}[{uid=0, upass=pass10, uname=user10, ubirth=1988-03-02}, {uid=1, upass=pass11, uname=user11, ubirth=1988-03-02}, {uid=2, upass=pass12, uname=user12, ubirth=1988-03-02}, {uid=3, upass=pass13, uname=user13, ubirth=1988-03-02}, {uid=4, upass=pass14, uname=user14, ubirth=1988-03-02}, {uid=5, upass=pass15, uname=user15, ubirth=1988-03-02}, {uid=6, upass=pass16, uname=user16, ubirth=1988-03-02}, {uid=7, upass=pass17, uname=user17, ubirth=1988-03-02}, {uid=8, upass=pass18, uname=user18, ubirth=1988-03-02}, {uid=9, upass=pass19, uname=user19, ubirth=1988-03-02}], prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8, navigateFirstPage=1, navigateLastPage=8, navigatepageNums=[1, 2, 3, 4, 5, 6, 7, 8]}
    }

}
