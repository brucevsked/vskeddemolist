package com.vsked.repository;

import com.vsked.repository.model.User;
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

    @Test
    public void select1(){
        String userName="admin";
        Mono<User> usersMono=userRepository.findByName(userName);
        log.debug("{}",usersMono.block());
    }

    @Test
    public void password(){
        String s="123456";
        String r=passwordEncoder.encode(s);
        log.info("{}",r);
    }
}
