package com.vsked.auth.application;

import org.springframework.transaction.annotation.Transactional;

public class AccountApplicationService {



    @Transactional
    public void changePassword(String email, String oldPassword, String newPasssord){
        //Account account = accountRepository.findById(email);
        //account.changePassword(oldPassword, newPasssord);
        //accountRepository.save(account);
    }

}
