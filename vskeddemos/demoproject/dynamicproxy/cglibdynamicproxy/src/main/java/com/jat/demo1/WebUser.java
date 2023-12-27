package com.jat.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUser {

    private static final Logger log = LoggerFactory.getLogger(WebUser.class);

    public String checkUserName(String userName){
        log.info("this is check userName"+userName);
        return "good job"+userName;
    }

    public int checkUserBirth(String birthday){
        log.info("this is check checkUserBirth"+birthday);
        return 8;
    }

    public void checkUserPassword(String password){
        log.info("this is check checkUserPassword"+password);
    }

    @Override
    public String toString() {
        log.info("当前类是:{}",getClass());
        return "WebUser{}"+getClass();
    }
}
