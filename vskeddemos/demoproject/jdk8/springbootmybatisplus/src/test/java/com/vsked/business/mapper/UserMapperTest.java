package com.vsked.business.mapper;

import com.vsked.business.model.User;
import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserMapperTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryById(){
        User user=userMapper.selectById(1);
        log.debug("{}",user);
    }

    @Test
    public void queryCustom(){
        User user=userMapper.test();
        log.debug("{}",user);
    }
}
