package com.jat.repositoryimpl.jpa;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class IPlatformAccountRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IPlatformAccountRepositoryTest.class);

    @Resource
    IPlatformAccountRepository iPlatformAccountRepository;

    @Test
    public void nextId(){
        Long id=iPlatformAccountRepository.nextId();
        log.debug("{}",id);
    }
}
