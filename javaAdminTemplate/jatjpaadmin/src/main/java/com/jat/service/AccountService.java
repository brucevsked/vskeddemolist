package com.jat.service;

import com.jat.repository.AccountRepository;
import com.jat.repository.model.AccountPO;
import com.jat.system.model.account.Account;
import com.jat.system.model.account.AccountName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService{
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    AccountRepository accountRepository;

    public AccountPO findBy(AccountName accountName){
        log.trace("findBy");
        return accountRepository.findByName(accountName.getName()).orElse(null);
    }

    public void isExist(AccountName accountName){
        AccountPO po=findBy(accountName);
        Account.checkIsExist(po);
    }

    public Account add(Account account,Integer isDel){
        isExist(account.getName());
        AccountPO po=account.boToPo(isDel);
        po=accountRepository.save(po);
        return Account.poToBo(po);
    }

    public Account save(Account account,Integer isDel){
        AccountPO po=account.boToPo(isDel);
        po=accountRepository.save(po);
        return Account.poToBo(po);
    }



}
