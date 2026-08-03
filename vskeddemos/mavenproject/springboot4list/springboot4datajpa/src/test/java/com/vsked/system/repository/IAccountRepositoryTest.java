package com.vsked.system.repository;

import com.vsked.system.model.po.AccountPO;
import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.Optional;

public class IAccountRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IAccountRepositoryTest.class);

    @Autowired
    IAccountRepository accountRepository;

    @Test
    public void save(){
        AccountPO po=new AccountPO(1L,"vsked","password1");
        accountRepository.save(po);
        AccountPO savedPo=accountRepository.findById(1L).orElse(null);
        log.debug("{}",savedPo);
    }

    @Test
    public void findByAccountName(){
        String accountName="testAccount";
        Optional<AccountPO> po=accountRepository.findByAccountName(accountName);
        log.debug("{}",po.orElse(null));
    }
}
