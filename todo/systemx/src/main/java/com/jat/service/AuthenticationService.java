package com.jat.service;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformCertificate;
import com.jat.bo.PlatformUserAccount;
import com.jat.bo.PlatformUserCertificate;

public class AuthenticationService {
    private PlatformAccountService platformAccountService;
    private PlatformUserAccountService platformUserAccountService;
    private PlatformCertificateService platformCertificateService;
    private PlatformUserCertificateService platformUserCertificateService;

    public void setPlatformAccountService(PlatformAccountService platformAccountService) {
        this.platformAccountService = platformAccountService;
    }

    public void setPlatformUserAccountService(PlatformUserAccountService platformUserAccountService) {
        this.platformUserAccountService = platformUserAccountService;
    }

    public void setPlatformCertificateService(PlatformCertificateService platformCertificateService) {
        this.platformCertificateService = platformCertificateService;
    }

    public void setPlatformUserCertificateService(PlatformUserCertificateService platformUserCertificateService) {
        this.platformUserCertificateService = platformUserCertificateService;
    }

    public PlatformCertificate login(String accountName, String accountPassword){
        PlatformAccount account=platformAccountService.create(accountName,accountPassword);
        PlatformUserAccount platformUserAccountStore=platformUserAccountService.findBy(account.getName().getName());
        platformUserAccountService.isNotExist(platformUserAccountStore);
        platformUserAccountStore.login(account);

        PlatformCertificate certificate=platformCertificateService.create();
        PlatformUserCertificate userCertificate=platformUserCertificateService.create(platformUserAccountStore.getUser(),certificate);
        userCertificate=platformUserCertificateService.save(userCertificate);
        return userCertificate.getPlatformCertificate();
    }
}
