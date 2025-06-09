package com.vsked.demo15;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Optional;

public class Certificate5RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Certificate5RepositoryTest.class);

    @Resource
    Certificate5Repository certificate5Repository;

    @Test
    public void findCertificate(){
        Long id=5001L;
        Optional<Certificate5PO> certificate5POOptional=certificate5Repository.findById(id);
        if(certificate5POOptional.isPresent()){
            Certificate5PO po=certificate5POOptional.get();
            log.info("当前找到了证书:{}",po);
            User5PO user=po.getUser();
            log.info("证书中用户:{}",user);
        }
    }
}
