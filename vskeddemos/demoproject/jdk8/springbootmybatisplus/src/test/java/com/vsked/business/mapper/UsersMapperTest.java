package com.vsked.business.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vsked.business.model.Users;
import com.vsked.test.BaseTestWithTransactional;
import org.apache.ibatis.executor.BatchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UsersMapperTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UsersMapperTest.class);

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryById(){
        Users users =userMapper.selectById(10L);
        log.debug("{}", users);
    }

    @Test
    public void queryByIdMap(){
        Map<String, String> users =userMapper.queryById(10L);
        log.debug("{}", users);
    }

    @Test
    public void queryCustom(){
        Users users =userMapper.test();
        log.debug("{}", users);
    }

    @Test
    public void queryForPage(){
        int pageNum =1;
        int pageSize =10;
        Page<Users> page =new Page<>(pageNum, pageSize);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.gt("uid", 18); // 查询uid大于 18 的用户
        Page<Users> users = userMapper.selectPage(page, wrapper);
        log.debug("{}", users);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void insertBatch(){
        List<Users> usersList =new LinkedList<>();

        for(int i=0;i<100;i++){
            Users users =new Users();
            users.setUid(i);
            users.setUname("user1"+i);
            users.setUpass("pass1"+i);
            users.setUbirth(LocalDate.of(1988,3,2));
            usersList.add(users);
        }

        List<BatchResult> row=userMapper.insert(usersList);
        log.debug("{}",row);
    }


}
