package com.jat.manager.business;

public class AccountNamePasswordAccount implements Account{

    AccountType accountType=AccountType.accountNamePassword;
    private AccountName accountName;
    private AccountPassword password;

    public AccountNamePasswordAccount(AccountName accountName, AccountPassword password) {
        this.accountName = accountName;
        this.password = password;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    public AccountName getAccountName() {
        return accountName;
    }

    public AccountPassword getPassword() {
        return password;
    }
}
