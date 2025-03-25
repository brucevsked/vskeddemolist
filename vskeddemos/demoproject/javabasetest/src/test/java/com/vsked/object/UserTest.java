package com.vsked.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class UserTest {

    private static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void create(){
        UserId id=new UserId(1L);
        UserName userName=new UserName("admin");
//        PresentAddress presentAddress=new PresentAddress(null);
        PresentAddress presentAddress=new PresentAddress("mali has little sheep");
        User user=new User(id,userName,presentAddress);
        log.info("{}",user);
    }
}
