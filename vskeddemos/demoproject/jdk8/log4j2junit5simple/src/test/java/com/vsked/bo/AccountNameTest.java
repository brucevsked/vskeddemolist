package com.vsked.bo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountNameTest {

    private static final Logger log = LoggerFactory.getLogger(AccountNameTest.class);

    @Test
    public void success(){
        AccountName accountName=new AccountName("BruceWill");
        log.debug("{}",accountName);
        assertEquals("BruceWill",accountName.getName());
    }

    @Test
    public void accountNameIsNotNull(){
        IllegalArgumentException exception= Assertions.assertThrows(IllegalArgumentException.class,()->{
            new AccountName(null);
        });

        log.debug("{}",exception.getMessage());//账户名不能为空！
        assertEquals("账户名不能为空！",exception.getMessage());
    }

    @Test
    public void accountNameIsNotNull3(){
        try{
            new AccountName(null);
        }catch (Exception e){
            assertEquals("账户名不能为空！",e.getMessage());
            log.error("账户名异常",e);
        }

    }
}
