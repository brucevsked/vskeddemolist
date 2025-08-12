package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class AccountTest {

    private static final Logger log = LoggerFactory.getLogger(AccountTest.class);

    @Test
    public void log(){
        log.trace("pre pare fire");
        log.debug("give me a gun ");
        log.info("now you have a gun");
        log.warn("this is a bad gun");
        log.error("I can't use it");
    }

    @Test
    public void create(){
        AccountId id=new AccountId(1);
        AccountName name=new AccountName("vsked");
        AccountPass password=new AccountPass("123456");
        Account account=new Account(id,name,password);
        log.info("{}",account);
    }
}
