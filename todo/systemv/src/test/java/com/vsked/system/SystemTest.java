package com.vsked.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SystemTest {
    private static final Logger log = LoggerFactory.getLogger(SystemTest.class);

    @Test
    public void login(){
        Id user1Id=new Id(1L);
        UserName user1Name=new UserName("user1");
        log.info("prepare userId:{} userName:{}",user1Id,user1Name);
        AccountName user1AccountName=new AccountName("admin");
        AccountPass user1AccountPass=new AccountPass("123456");
        Account user1Account=new NamePassAccount(user1AccountName,user1AccountPass);
        log.info("prepare userAccount:{}",user1Account);
        User user1=new User(user1Id,user1Name,user1Account);
        log.info("prepare user:{}",user1Account);

        AccountName tmpLoginAccountName=new AccountName("admin");
        AccountPass tmpLoginAccountPass=new AccountPass("123456");
        Account tmpLogin=new NamePassAccount(tmpLoginAccountName,tmpLoginAccountPass);
        log.info("prepare temp login account:{}",tmpLogin);

        user1.login(tmpLogin);

        log.info("login success");

    }
}
