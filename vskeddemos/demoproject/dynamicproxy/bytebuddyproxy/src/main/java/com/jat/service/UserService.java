package com.jat.service;

import com.jat.domain.UserAccount;
import com.jat.manager.UserAccountManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

        //方法1
        public String username(){
            log.debug("username().....");
            return "张三";
        }

        //方法2
        public String address(String username){
            log.debug("address(String username).....");
            return username+"来自 【山东-济南-市中区】";
        }

        //方法3
        public String address(String username,String city){
            log.debug("address(String username,String city).....");
            return username+"来自 【山东省"+city+"】";
        }

        public void login(String accountName,String accountPass){
            UserAccountManager userAccountManager=new UserAccountManager();
            UserAccount userAccount=userAccountManager.findBy(accountName);
            userAccount.login(accountPass);
        }
}
