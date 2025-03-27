package com.jat.model;

import com.jat.test.JfinalTesgNgBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

public class UserTest extends JfinalTesgNgBaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void queryOne(){
        User user1=User.dao.findById(1);
        log.debug("{}",user1);
        User user2= User.dao.findFirst("select * from user where id=?",1);
        log.debug("{}",user2);
    }

    @Test
    public void queryList(){
        List<User> userListAll=User.dao.findAll();
        log.debug("{}",userListAll);

        List<User> userList1=User.dao.find("select * from user");
        log.debug("{}",userList1);
    }
}
