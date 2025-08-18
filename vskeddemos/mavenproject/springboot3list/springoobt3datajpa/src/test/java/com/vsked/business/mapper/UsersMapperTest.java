package com.vsked.business.mapper;

import com.vsked.jpa.model.Users;
import com.vsked.jpa.repository.UsersRepository;
import com.vsked.test.BaseTestWithTransactional;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class UsersMapperTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UsersMapperTest.class);

    @Resource
    UsersRepository usersRepository;

    @Test
    public void queryById(){
        Users users = usersRepository.findById(10L).get();
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

        usersRepository.saveAll(usersList);
    }


}
