package com.jat.config;

import com.jat.manager.PlatformAccountManager;
import com.jat.manager.PlatformCertificateManager;
import com.jat.manager.PlatformIdManager;
import com.jat.manager.PlatformUserAccountManager;
import com.jat.manager.PlatformUserCertificateManager;
import com.jat.manager.PlatformUserManager;
import com.jat.repository.PlatformAccountRepository;
import com.jat.repository.PlatformCertificateRepository;
import com.jat.repository.PlatformUserAccountRepository;
import com.jat.repository.PlatformUserCertificateRepository;
import com.jat.repository.PlatformUserRepository;
import com.jat.service.AuthenticationService;
import com.jat.service.PlatformAccountService;
import com.jat.service.PlatformCertificateService;
import com.jat.service.PlatformIdService;
import com.jat.service.PlatformUserAccountService;
import com.jat.service.PlatformUserCertificateService;
import com.jat.service.PlatformUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;

@Configuration
public class BeanManager {

    @Resource
    private PlatformAccountRepository platformAccountRepositoryImpl;
    @Resource
    private PlatformUserRepository platformUserRepositoryImpl;
    @Resource
    private PlatformUserAccountRepository platformUserAccountRepositoryImpl;
    @Resource
    private PlatformCertificateRepository platformCertificateRepositoryImpl;
    @Resource
    private PlatformUserCertificateRepository platformUserCertificateRepositoryImpl;

    @Bean("platformIdManager")
    public PlatformIdManager getIdManager(){
        PlatformIdManager manager=new PlatformIdManager();
        manager.setPlatformAccountRepository(platformAccountRepositoryImpl);
        manager.setPlatformUserRepository(platformUserRepositoryImpl);
        manager.setPlatformCertificateRepository(platformCertificateRepositoryImpl);
        return manager;
    }

    @Bean("platformIdService")
    public PlatformIdService getIdService(){
        PlatformIdService service=new PlatformIdService();
        service.setPlatformIdManager(getIdManager());
        return service;
    }

    @Bean("platformAccountManager")
    public PlatformAccountManager getAccountManager(){
        PlatformAccountManager manager=new PlatformAccountManager();
        manager.setPlatformAccountRepository(platformAccountRepositoryImpl);
        return manager;
    }

    @Bean("platformAccountService")
    public PlatformAccountService getAccountService(){
        PlatformAccountService service=new PlatformAccountService();
        service.setPlatformAccountManager(getAccountManager());
        service.setPlatformIdService(getIdService());
        return service;
    }

    @Bean("platformUserManager")
    public PlatformUserManager getUserManager(){
        PlatformUserManager manager=new PlatformUserManager();
        manager.setPlatformUserRepository(platformUserRepositoryImpl);
        return manager;
    }

    @Bean("platformUserService")
    public PlatformUserService getUserService(){
        PlatformUserService service=new PlatformUserService();
        service.setPlatformUserManager(getUserManager());
        service.setPlatformIdService(getIdService());
        return service;
    }

    @Bean("platformUserAccountManager")
    public PlatformUserAccountManager getUserAccountManager(){
        PlatformUserAccountManager manager=new PlatformUserAccountManager();
        manager.setPlatformUserAccountRepository(platformUserAccountRepositoryImpl);
        return manager;
    }
    @Bean("platformUserAccountService")
    public PlatformUserAccountService getUserAccountService(){
        PlatformUserAccountService service=new PlatformUserAccountService();
        service.setPlatformUserAccountManager(getUserAccountManager());
        service.setPlatformAccountService(getAccountService());
        service.setPlatformUserService(getUserService());
        return service;
    }
    @Bean("platformCertificateManager")
    public PlatformCertificateManager getCertificateManager(){
        PlatformCertificateManager manager=new PlatformCertificateManager();
        manager.setPlatformCertificateRepository(platformCertificateRepositoryImpl);
        return manager;
    }

    @Bean("platformCertificateService")
    public PlatformCertificateService getCertificateService(){
        PlatformCertificateService service=new PlatformCertificateService();
        service.setPlatformCertificateManager(getCertificateManager());
        service.setPlatformIdService(getIdService());
        return service;
    }

    @Bean("platformUserCertificateManager")
    public PlatformUserCertificateManager getUserCertificateManager(){
        PlatformUserCertificateManager manager=new PlatformUserCertificateManager();
        manager.setPlatformUserCertificateRepository(platformUserCertificateRepositoryImpl);
        return manager;
    }

    @Bean("platformUserCertificateService")
    public PlatformUserCertificateService getUserCertificateService(){
        PlatformUserCertificateService service=new PlatformUserCertificateService();
        service.setPlatformUserCertificateManager(getUserCertificateManager());
        return service;

    }

    @Bean("authenticationService")
    public AuthenticationService getAuthenticationService(){
        AuthenticationService service=new AuthenticationService();
        service.setPlatformAccountService(getAccountService());
        service.setPlatformUserAccountService(getUserAccountService());
        service.setPlatformCertificateService(getCertificateService());
        service.setPlatformUserCertificateService(getUserCertificateService());
        return service;
    }



}
