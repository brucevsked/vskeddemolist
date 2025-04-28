package com.vsked.r2dbc.mysql.repository;

import com.vsked.r2dbc.mysql.model.Users;
import com.vsked.test.BaseTestWithoutTransactional;
import jakarta.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

public class UserRepositoryTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Resource
    UsersRepository usersRepository;

    @Autowired
    private R2dbcEntityTemplate entityTemplate;

    @Test
    public void save(){
        String userName="userSs1a55666";
        Users myUser=new Users(null,userName,"password1");
        log.debug("{}",myUser);
        usersRepository.save(myUser).subscribe();
        Mono<Users> usersMono=usersRepository.findByUserName(userName);
        log.debug("{}",usersMono.block());
    }

    @Test
    public void saveWithId(){
        String userName="hasIdUserName";
        Users myUser=new Users(21,userName,"password2");
        log.debug("{}",myUser);
        Mono<Void> userMono=entityTemplate.insert(Users.class).using(myUser).then();
        log.debug("{}",userMono.block());
    }

    @Test
    public void del(){
        usersRepository.deleteById(1);
    }

    @Test
    public void select1(){
        Mono<Users> usersMono=usersRepository.findById(1);
        log.debug("{}",usersMono.block());

    }
}
