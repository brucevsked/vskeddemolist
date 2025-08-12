package com.vsked.repository;


import com.vsked.entity.Users;
import com.vsked.test.BaseTestWithTransactional;
import jakarta.annotation.Resource;
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

    @Test
    public void queryById(){
        Users users =userRepository.findById(1L).get();
        log.debug("{}", users);
    }

    @Rollback(value = false) //事务不回滚
    @Test
    public void insertBatch(){
        List<Users> usersList =new LinkedList<>();

        for(int i=0;i<100;i++){
            Users users =new Users(i,"user1"+i,"pass1"+i,LocalDate.of(1988,3,2));
            usersList.add(users);
        }

        List<Users> rows=userRepository.saveAll(usersList);
        log.debug("{}",rows);
    }


}
