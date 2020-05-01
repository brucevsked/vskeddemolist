package com.vsked.infrastruture.repository;

import com.vsked.auth.entity.User;
import com.vsked.auth.repository.UserRepository;
import com.vsked.test.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

public class UserRepositoryTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll(){
        List<User> userList=userRepository.findAll();
        for(User user:userList){
            log.info("|"+user.toString()+"|");
        }


    }
}
