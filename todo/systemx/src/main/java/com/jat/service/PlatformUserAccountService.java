package com.jat.service;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserAccount;
import com.jat.manager.PlatformUserAccountManager;

public class PlatformUserAccountService {

    private PlatformUserAccountManager platformUserAccountManager;

    private PlatformAccountService platformAccountService;
    private PlatformUserService platformUserService;

    public void setPlatformUserAccountManager(PlatformUserAccountManager platformUserAccountManager) {
        this.platformUserAccountManager = platformUserAccountManager;
    }

    public void setPlatformAccountService(PlatformAccountService platformAccountService) {
        this.platformAccountService = platformAccountService;
    }

    public void setPlatformUserService(PlatformUserService platformUserService) {
        this.platformUserService = platformUserService;
    }

    public PlatformUserAccount create(String accountName, String accountPassword){
        PlatformAccount account=platformAccountService.create(accountName,accountPassword);
        PlatformAccount accountStore=platformAccountService.findBy(account.getName().getName());
        account.isExist(accountStore);

        PlatformUser user=platformUserService.create(accountName,null);

        PlatformUserAccount userAccount=platformUserAccountManager.create(user,account);
        return platformUserAccountManager.save(userAccount);
    }

    public PlatformUserAccount register(String accountName, String accountPassword, String passwordAgain){
        PlatformAccount account=platformAccountService.create(accountName,accountPassword,passwordAgain);
        PlatformAccount accountStore=platformAccountService.findBy(account.getName().getName());
        account.isExist(accountStore);

        PlatformUser user=platformUserService.create(accountName,null);

        PlatformUserAccount userAccount=platformUserAccountManager.create(user,account);
        return platformUserAccountManager.save(userAccount);
    }

    public void login(String accountName, String accountPassword){
        //TODO login process
        PlatformAccount account=platformAccountService.create(accountName,accountPassword);
        PlatformUserAccount platformUserAccountStore=platformUserAccountManager.findBy(account.getName().getName());
        PlatformUserAccount.isNotExist(platformUserAccountStore);

        platformUserAccountStore.login(account);




    }
}
