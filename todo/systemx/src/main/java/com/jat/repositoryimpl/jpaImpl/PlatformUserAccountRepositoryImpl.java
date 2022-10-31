package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserAccount;
import com.jat.po.PlatformAccountPO;
import com.jat.po.PlatformUserAccountPO;
import com.jat.po.PlatformUserPO;
import com.jat.repository.PlatformUserAccountRepository;
import com.jat.repositoryimpl.jpa.IPlatformUserAccountRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PlatformUserAccountRepositoryImpl implements PlatformUserAccountRepository {

    @Resource
    IPlatformUserAccountRepository iPlatformUserAccountRepository;
    @Resource
    PlatformAccountRepositoryImpl platformAccountRepository;
    @Resource
    PlatformUserRepositoryImpl platformUserRepository;

    @Override
    public PlatformUserAccount save(PlatformUserAccount bo) {
        PlatformUserAccountPO po=boToPo(bo);
        po=iPlatformUserAccountRepository.save(po);
        return poToBo(po);
    }

    public PlatformUserAccount findBy(PlatformAccountName platformAccountName) {
        PlatformUserAccountPO po=iPlatformUserAccountRepository.findByAccountName(platformAccountName.getName()).orElse(null);
        return poToBo(po);
    }

    public PlatformUserAccount poToBo(PlatformUserAccountPO po){
        if(po==null){
            return null;
        }

        PlatformUser user=platformUserRepository.poToBo(po.getUser());
        PlatformAccount account=platformAccountRepository.poToBo(po.getAccount());

        return new PlatformUserAccount(user,account);
    }

    public PlatformUserAccountPO boToPo(PlatformUserAccount po){
        if(po==null){
            return null;
        }
        PlatformUserPO userPO=platformUserRepository.boToPo(po.getUser());
        PlatformAccountPO accountPO=platformAccountRepository.boToPo(po.getAccount());
        return new PlatformUserAccountPO(userPO,accountPO);
    }
}
