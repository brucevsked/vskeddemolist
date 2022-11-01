package com.jat.repositoryimpl.jpaImpl;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class PlatformCertificateRepositoryImplTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(PlatformCertificateRepositoryImplTest.class);

    @Resource
    PlatformCertificateRepositoryImpl platformCertificateRepository;

    @Test
    public void nextId(){
        Long id=platformCertificateRepository.nextId();
        log.debug("{}",id);
    }

}
