package com.jat.config;

import com.jat.manager.PlatformAccountManager;
import com.jat.manager.PlatformIdManager;
import com.jat.manager.PlatformUserManager;
import com.jat.repositoryimpl.jpaImpl.PlatformAccountRepositoryImpl;
import com.jat.repositoryimpl.jpaImpl.PlatformUserRepositoryImpl;
import com.jat.service.PlatformAccountService;
import com.jat.service.PlatformIdService;
import com.jat.service.PlatformUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;

@Configuration
public class BeanManager {

    @Resource
    private PlatformAccountRepositoryImpl platformAccountRepositoryImpl;
    @Resource
    private PlatformUserRepositoryImpl platformUserRepository;

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
        return service;
    }

    @Bean("platformUserManager")
    public PlatformUserManager getUserManager(){
        PlatformUserManager manager=new PlatformUserManager();
        manager.setPlatformUserRepository(platformUserRepository);
        return manager;
    }

    @Bean("platformUserService")
    public PlatformUserService getUserService(){
        PlatformUserService service=new PlatformUserService();
        service.setPlatformUserManager(getUserManager());
        return service;
    }

    @Bean("platformIdManager")
    public PlatformIdManager getIdManager(){
        PlatformIdManager manager=new PlatformIdManager();
        manager.setPlatformAccountRepository(platformAccountRepositoryImpl);
        manager.setPlatformUserRepository(platformUserRepository);
        return manager;
    }

    @Bean("platformIdService")
    public PlatformIdService getIdService(){
        PlatformIdService service=new PlatformIdService();
        service.setPlatformIdManager(getIdManager());
        return service;
    }

}
