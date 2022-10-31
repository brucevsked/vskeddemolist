package com.jat.manager;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserAccount;
import com.jat.repository.PlatformUserAccountRepository;

public class PlatformUserAccountManager {
    private PlatformUserAccountRepository platformUserAccountRepository;

    public void setPlatformUserAccountRepository(PlatformUserAccountRepository platformUserAccountRepository) {
        this.platformUserAccountRepository = platformUserAccountRepository;
    }

    public PlatformUserAccount create(PlatformUser user, PlatformAccount account){
        return new PlatformUserAccount(user,account);
    }

    public PlatformUserAccount save(PlatformUserAccount platformUserAccount){
        return platformUserAccountRepository.save(platformUserAccount);
    }

    public PlatformUserAccount findBy(String accountName){
        PlatformAccountName accountNameQuery=new PlatformAccountName(accountName);
        return platformUserAccountRepository.findBy(accountNameQuery);
    }
}
