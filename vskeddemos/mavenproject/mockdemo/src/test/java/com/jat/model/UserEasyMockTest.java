package com.jat.model;

import org.easymock.EasyMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class UserEasyMockTest {

    private static final Logger log = LoggerFactory.getLogger(UserEasyMockTest.class);


    @Test
    public void mock1Test() {
        User user = new User(1L, "admin", "123456");
        log.debug("{}", user); //user you create
        log.debug("{}", user.getId()); //user you create
        log.debug("{}", user.getName()); //user you create
        log.debug("{}", user.getPassword()); //user you create

        User userMock= EasyMock.mock(User.class);
        // set mock method            set return value
        EasyMock.expect(userMock.getId()).andReturn(66L);
        EasyMock.expect(userMock.getName()).andReturn("hard");
        EasyMock.expect(userMock.getPassword()).andReturn("good");

        EasyMock.replay(userMock);//need here

        log.debug("{}",userMock.getId()); //mock data
        log.debug("{}",userMock.getName()); //mock data
        log.debug("{}",userMock.getPassword()); //mock data

    }
}
