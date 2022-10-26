package com.jat.manager;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;
import com.jat.repository.PlatformAccountRepository;

public class PlatformAccountManager {
    private PlatformAccountRepository platformAccountRepository;

    public void setPlatformAccountRepository(PlatformAccountRepository platformAccountRepository) {
        this.platformAccountRepository = platformAccountRepository;
    }

    public PlatformAccount create(Long id, String name, String pass){
        return new PlatformAccount(id,name,pass);
    }

    public PlatformAccount findBy(String accountName){
        PlatformAccountName accountNameQuery=new PlatformAccountName(accountName);
        return platformAccountRepository.findBy(accountNameQuery);
    }
}
