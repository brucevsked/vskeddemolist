package com.jat.manager;

import com.jat.manager.business.Account;
import com.jat.manager.business.AccountName;
import com.jat.manager.business.AccountNamePasswordAccount;
import com.jat.manager.business.AccountPassword;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

public class AccountManagerTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(AccountManagerTest.class);

    @Autowired
    AccountNamePasswordAccountManager accountNamePasswordAccountManager;


    @Rollback(value = true) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.trace("start save");
        AccountName accountName=new AccountName("vsked");
        AccountPassword password=new AccountPassword("123456");
        Account account=new AccountNamePasswordAccount(accountName,password);
        accountNamePasswordAccountManager.save(account);
        log.info("finish save");
    }
}
