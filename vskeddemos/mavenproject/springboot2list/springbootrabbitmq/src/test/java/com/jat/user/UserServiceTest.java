package com.jat.user;

import com.jat.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserServiceTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Test
    public void testEventSave(){
        User user=new User(1006,"测试用户");
        userService.save(user);
        User user1=new User(1007,"老哥");
        userService.save(user1);
        User user2=new User(1008,"smallSister");
        userService.save(user2);
    }

    @Test
    public void testEventRead(){
        String uid="1008";
        Object user=userService.read(uid);
        log.info("{}",user);
        //这里如果想转回对象，可以用JSON转换工具进行转换如Gson或Jackson等技术

    }
}
