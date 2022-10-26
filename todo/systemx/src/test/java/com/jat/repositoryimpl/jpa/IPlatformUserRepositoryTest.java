package com.jat.repositoryimpl.jpa;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.Optional;

public class IPlatformUserRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IPlatformUserRepositoryTest.class);

    @Resource
    IPlatformUserRepository iPlatformUserRepository;

    @Test
    public void nextId(){
        Long id=iPlatformUserRepository.nextId();
        log.debug("{}",id);
    }
}
