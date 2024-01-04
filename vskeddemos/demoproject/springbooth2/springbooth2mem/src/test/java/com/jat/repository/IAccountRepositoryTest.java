package com.jat.repository;

import com.jat.model.po.AccountPO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class IAccountRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IAccountRepositoryTest.class);

    @Resource
    IAccountRepository accountRepository;

    @Test
    public void save(){
        AccountPO po=new AccountPO(1L,"vsked","password1");
        accountRepository.save(po);
        AccountPO savedPo=accountRepository.findById(1L).orElse(null);
        log.debug("{}",savedPo);
    }
}
