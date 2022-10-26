package com.jat.service;

import com.jat.bo.PlatformAccount;
import com.jat.manager.PlatformAccountManager;

public class PlatformAccountService {
    private PlatformAccountManager platformAccountManager;
    private PlatformIdService platformIdService;

    public void setPlatformAccountManager(PlatformAccountManager platformAccountManager) {
        this.platformAccountManager = platformAccountManager;
    }

    public void setPlatformIdService(PlatformIdService platformIdService) {
        this.platformIdService = platformIdService;
    }

    public PlatformAccount create(String accountName, String accountPassword){
        Long accountId=platformIdService.nextAccountId();
        return platformAccountManager.create(accountId,accountName,accountName);
    }
    public PlatformAccount findBy(String accountName){
        return platformAccountManager.findBy(accountName);
    }
}
