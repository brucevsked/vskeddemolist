package com.vsked.repository;

import com.vsked.mapper.UserMapper;
import com.vsked.entity.Users;
import com.vsked.test.BaseTestWithTransactional;
import jakarta.annotation.Resource;
import org.apache.ibatis.executor.BatchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class UsersRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UsersRepositoryTest.class);

    @Resource
    UserRepository userRepository;
    @Resource
    UserMapper userMapper;

    @Test
    public void queryByIdJPA(){
        Users users =userRepository.findById(1L).get();
        log.debug("{}", users);
    }

    @Test
    public void queryByIdMybatisPlus(){
        com.vsked.model.Users users =userMapper.selectById(1L);
        log.debug("{}", users);
    }

    @Test
    public void queryById(){
        Users users =userRepository.findById(1L).get();
        log.debug("{}", users);

        com.vsked.model.Users users1 =userMapper.selectById(1L);
        log.debug("{}", users1);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void insertBatch(){
        List<Users> usersList =new LinkedList<>();

        for(int i=0;i<50;i++){
            Users users =new Users(i,"user1"+i,"pass1"+i,LocalDate.of(1988,3,2));
            usersList.add(users);
        }

        List<Users> rows=userRepository.saveAll(usersList);
        log.debug("{}",rows);

        List<com.vsked.model.Users> usersList1 =new LinkedList<>();
        for(int i=50;i<100;i++){
            com.vsked.model.Users users1 =new com.vsked.model.Users();
            users1.setUid(i);
            users1.setUname("user-------1"+i);
            users1.setUpass("pass-------1"+i);
            users1.setUbirth(LocalDate.of(1988,3,2));
            usersList1.add(users1);
        }

        List<BatchResult> row=userMapper.insert(usersList1);
        log.debug("{}",row);
    }


}
