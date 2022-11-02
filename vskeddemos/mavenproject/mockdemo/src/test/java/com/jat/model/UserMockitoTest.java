package com.jat.model;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class UserMockitoTest {

    private static final Logger log = LoggerFactory.getLogger(UserMockitoTest.class);

    @Test
    public void mock1Test(){
        User user=new User(1L,"admin","123456");
        log.debug("{}",user); //user you create
        log.debug("{}",user.getId()); //user you create
        log.debug("{}",user.getName()); //user you create
        log.debug("{}",user.getPassword()); //user you create

        User userMock= Mockito.mock(User.class);
        // set mock method            set return value
        Mockito.when(userMock.getId()).thenReturn(8L);
        Mockito.when(userMock.getName()).thenReturn("billy");
        Mockito.when(userMock.getPassword()).thenReturn("luck");

        log.debug("{}",userMock.getId()); //mock data
        log.debug("{}",userMock.getName()); //mock data
        log.debug("{}",userMock.getPassword()); //mock data


    }

}
