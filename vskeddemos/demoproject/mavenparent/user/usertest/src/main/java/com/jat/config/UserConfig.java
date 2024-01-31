package com.jat.config;

import com.jat.manager.AccountNamePasswordAccountManager;
import com.jat.repository.AccountNamePasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    AccountNamePasswordRepository accountRepositorySpringDataJPAImpl;


    @Bean(name = "accountNamePasswordAccountManager")
    public AccountNamePasswordAccountManager getAccountManager(){
        AccountNamePasswordAccountManager accountManager=new AccountNamePasswordAccountManager();
        accountManager.setAccountRepository(accountRepositorySpringDataJPAImpl);
        return accountManager;
    }

}
