package com.jat.model.business;

import com.jat.test.BaseTestWithoutTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserTest extends BaseTestWithoutTransactional {

    @Autowired
    User user;

    @Test
    public void testCreate(){
        user.getId();
        user.getName();
        user.jump(88);
        user.run(2,"shanDa");
    }
}
