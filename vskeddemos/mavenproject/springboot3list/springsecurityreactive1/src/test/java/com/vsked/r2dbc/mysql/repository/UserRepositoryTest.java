package com.vsked.r2dbc.mysql.repository;

import com.vsked.domain.User;
import com.vsked.repository.UserRepository;
import com.vsked.test.BaseTestWithoutTransactional;
import jakarta.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

public class UserRepositoryTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Resource
    UserRepository userRepository;
    @Resource
    PasswordEncoder passwordEncoder;

//    @Test
//    public void save(){
//        String userName="userSs1a55666";
//        User myUser=new User(null,userName,"password1");
//        log.debug("{}",myUser);
//        userRepository.save(myUser).subscribe();
//        Mono<Users> usersMono=userRepository.findByUserName(userName);
//        log.debug("{}",usersMono.block());
//    }


    @Test
    public void select1(){
        String userName="admin";
        Mono<User> usersMono=userRepository.findByUsername(userName);
        log.debug("{}",usersMono.block());
    }

    @Test
    public void password(){
        String s="123456";
        String r=passwordEncoder.encode(s);
        log.info("{}",r);
    }
}
