package com.training.jpa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.training.jpa.domain.AccountInfo;
import com.training.jpa.domain.UserInfo;



public interface UserService {
	
    public AccountInfo createNewAccount(String username, String password, Integer initBalance);

    public void updateAccountInfo(Long accountId, UserInfo newInfo);
    
    public void deleteAccountInfo(Long accountId);
    
    public AccountInfo findAccountInfoById(Long id);

    public List<AccountInfo> findByBalanceGreaterThan(Integer balance,Pageable pageable);
    
    public List<AccountInfo> findAccountsByName(String name);
}
