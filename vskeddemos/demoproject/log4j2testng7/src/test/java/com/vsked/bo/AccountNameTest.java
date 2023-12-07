package com.vsked.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountNameTest {

    private static final Logger log = LoggerFactory.getLogger(AccountNameTest.class);

    @Test
    public void success(){
        AccountName accountName=new AccountName("BruceWill");
        log.debug("{}",accountName);
        Assert.assertEquals(accountName.getName(),"BruceWill");
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void accountNameIsNotNull(){
        new AccountName(null);
    }

    @Test
    public void accountNameIsNotNull2(){
        Assert.expectThrows(IllegalArgumentException.class,()->new AccountName(null));
    }

    @Test
    public void accountNameIsNotNull3(){
        try{
            new AccountName(null);
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"账户名不能为空！");
            log.error("账户名异常",e);
        }

    }
}
