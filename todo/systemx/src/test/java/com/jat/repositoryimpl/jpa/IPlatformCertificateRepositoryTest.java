package com.jat.repositoryimpl.jpa;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class IPlatformCertificateRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IPlatformCertificateRepositoryTest.class);

    @Resource
    IPlatformCertificateRepository iPlatformCertificateRepository;

    @Test
    public void nextId(){
        Long id=iPlatformCertificateRepository.nextId();
        log.debug("{}",id);
    }
}
