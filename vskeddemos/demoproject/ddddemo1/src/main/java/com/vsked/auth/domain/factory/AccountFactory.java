package com.vsked.auth.domain.factory;

import com.vsked.auth.domain.PO.AccountPO;
import com.vsked.auth.domain.aggregate.Account;
import com.vsked.auth.domain.valueobject.AccountId;

public class AccountFactory {

    public static Account createAccountFromPO(AccountPO accountPO){
        AccountId accountId=new AccountId(accountPO.getAccountId());
        String accountName=accountPO.getAccountName();
        String password=accountPO.getPassword();
        return new Account(accountId,accountName,password);
    }
}
