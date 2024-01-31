package com.jat.manager;

import com.jat.manager.business.AccountName;
import com.jat.manager.business.AccountPassword;
import com.jat.repository.AccountNamePasswordRepository;
import com.jat.manager.business.Account;
import com.jat.manager.business.AccountNamePasswordAccount;
import com.jat.repository.entity.AccountNamePasswordAccountEntity;

public class AccountNamePasswordAccountManager{

    private AccountNamePasswordRepository accountNamePasswordRepository;

    public void setAccountRepository(AccountNamePasswordRepository accountNamePasswordRepository) {
        this.accountNamePasswordRepository = accountNamePasswordRepository;
    }

    public Account entityToAccount(AccountNamePasswordAccountEntity accountEntity) {
        AccountName accountName=new AccountName(accountEntity.getAccountName());
        AccountPassword accountPassword=new AccountPassword(accountEntity.getPassword());
        Account account=new AccountNamePasswordAccount(accountName,accountPassword);
        return account;
    }

    public AccountNamePasswordAccountEntity accountToEntity(Account account) {
        AccountNamePasswordAccount accountNamePasswordAccount= (AccountNamePasswordAccount) account;
        String accountName=accountNamePasswordAccount.getAccountName().getName();
        String password=accountNamePasswordAccount.getPassword().getPassword();
        AccountNamePasswordAccountEntity accountEntity=new AccountNamePasswordAccountEntity(accountName,password);
        return accountEntity;
    }

    public void save(Account account){
        AccountNamePasswordAccountEntity accountEntity=accountToEntity(account);
        accountNamePasswordRepository.save(accountEntity);
    }


}
