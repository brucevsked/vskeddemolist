package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformAccountPO;
import com.jat.po.PlatformUserAccountPK;
import com.jat.po.PlatformUserAccountPO;
import com.jat.po.PlatformUserPO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Optional;

public class IPlatformUserAccountRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(IPlatformUserAccountRepositoryTest.class);

    @Resource
    IPlatformUserAccountRepository userAccountRepository;

    @Rollback(value = false)
    @Test
    public void save(){
        PlatformUserPO user=new PlatformUserPO(3L,"test3",null);
        PlatformAccountPO account=new PlatformAccountPO(3L,"test3","654321");
        PlatformUserAccountPO po=new PlatformUserAccountPO(user,account);
        userAccountRepository.save(po);
    }

    @Test
    public void query(){
        Long userId=2L;
        Long accountId=2L;

        PlatformUserAccountPK pk1=new PlatformUserAccountPK(userId,accountId);
        Optional<PlatformUserAccountPO> poOptional=userAccountRepository.findById(pk1);
        PlatformUserAccountPO po=poOptional.orElse(null);
        log.debug("{}",po);
    }

    @Test
    public void queryByAccountName(){
        String accountName="admin";
        Optional<PlatformUserAccountPO> poOptional=userAccountRepository.findByAccountName(accountName);
        PlatformUserAccountPO po=poOptional.orElse(null);
        log.debug("{}",po);
    }

}
