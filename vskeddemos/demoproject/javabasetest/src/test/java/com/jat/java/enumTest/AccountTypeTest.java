package com.jat.java.enumTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTypeTest {
    private static final Logger log = LoggerFactory.getLogger(AccountTypeTest.class);

    @Test
    public void createById(){
        AccountType accountType1=AccountType.findBy(Byte.valueOf("0"));
        log.debug("{}",accountType1);
        Assert.assertEquals(accountType1.getId(),Byte.valueOf("0"));
    }

    @Test
    public void createByName(){
        AccountType accountType2=AccountType.findBy("nameAndPass");
        log.debug("{}",accountType2);
        Assert.assertEquals(accountType2.getName(),"nameAndPass");
    }


}
