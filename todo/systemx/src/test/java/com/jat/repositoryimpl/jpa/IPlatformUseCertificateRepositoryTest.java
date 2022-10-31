package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformCertificatePO;
import com.jat.po.PlatformUserCertificatePO;
import com.jat.po.PlatformUserPO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.time.LocalDateTime;

public class IPlatformUseCertificateRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IPlatformUseCertificateRepositoryTest.class);

    @Resource
    IPlatformUserCertificateRepository iPlatformUserCertificateRepository;

    @Rollback(value = false)
    @Test
    public void save(){
        PlatformUserPO user=new PlatformUserPO(3L,"test3",null);
        PlatformCertificatePO certificate=new PlatformCertificatePO(1L, LocalDateTime.now());
        PlatformUserCertificatePO po=new PlatformUserCertificatePO(user,certificate);
        PlatformUserCertificatePO poSaved=iPlatformUserCertificateRepository.save(po);
        log.debug("{}",poSaved);
    }


}
