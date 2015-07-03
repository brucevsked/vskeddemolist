package com.training.jpa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.training.jpa.domain.AccountInfo;



public interface UserService {
    public AccountInfo createNewAccount(String username, String password, Integer initBalance);

    public AccountInfo findAccountInfoById(Long id);

    public List<AccountInfo> findByBalanceGreaterThan(Integer balance,Pageable pageable);
}
