package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class PlatformAccountRepositoryImplTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(PlatformAccountRepositoryImplTest.class);

    @Resource
    PlatformAccountRepositoryImpl platformAccountRepository;

    @Test
    public void nextId(){
        Long id=platformAccountRepository.nextId();
        log.debug("{}",id);
    }

    @Test
    public void findByName(){
        PlatformAccountName platformAccountName=new PlatformAccountName("sysadmin");
        PlatformAccount platformAccount=platformAccountRepository.findBy(platformAccountName);
        log.debug("{}",platformAccount);
    }
}
