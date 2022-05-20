package com.jat.user;

import com.jat.test.BaseTestWithoutTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserServiceTest extends BaseTestWithoutTransactional {

    @Autowired
    UserService userService;

    @Test
    public void testEvent(){
        User user=new User(1006,"vsked");
        userService.save(user);
    }
}
