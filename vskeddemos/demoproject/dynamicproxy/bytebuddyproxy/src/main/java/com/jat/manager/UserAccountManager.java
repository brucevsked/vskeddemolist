package com.jat.manager;

import com.jat.domain.Account;
import com.jat.domain.User;
import com.jat.domain.UserAccount;

public class UserAccountManager {

    public UserAccount findBy(String accountName){
        User user=new User(1L,"admin");
        Account account=new Account(1L,"admin","123456");
        return new UserAccount(user,account);
    }

}
