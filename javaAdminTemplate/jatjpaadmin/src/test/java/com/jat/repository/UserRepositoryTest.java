package com.jat.repository;

import com.jat.repository.model.UserPO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.testng.annotations.Test;


public class UserRepositoryTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    public void findById(){
        Integer userId=1;
        UserPO userPO=userRepository.findById(userId).orElse(null);
        log.debug("{}",userPO);
    }

    @Test
    public void findByNameLikeAndPhoneLikeAndIsDelIs(){
        int page=0;
        int size=10;
        String userName="%";
        String phone="%";
        int isDel=0;
        Pageable pageable= PageRequest.of(page,size);
        Page<UserPO> users=userRepository.findByNameLikeAndPhoneLikeAndIsDelIs(userName,phone,isDel,pageable);
        log.debug("{}",users);
    }

    @Test
    public void findByNameLikeAndPhoneLikeAndIsDelIsLikeAndUserAccountAccountNameLike(){
        int page=0;
        int size=10;
        String userName="%";
        String phone="%";
        int isDel=0;
        String accountName="%";
        Pageable pageable= PageRequest.of(page,size);
        Page<UserPO> users=userRepository.findByNameLikeAndPhoneLikeAndIsDelIsLikeAndUserAccountAccountNameLike(userName,phone,isDel,accountName,pageable);
        log.debug("{}",users);
    }
}
