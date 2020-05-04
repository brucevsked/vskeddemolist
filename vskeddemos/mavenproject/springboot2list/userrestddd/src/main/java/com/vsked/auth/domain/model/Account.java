package com.vsked.auth.domain.model;

import com.vsked.domain.shared.Entity;
import org.apache.commons.lang3.Validate;

public class Account implements Entity<Account> {

    private AccountId accountId;
    private String name;
    private String pass;

    public Account(AccountId accountId, String name, String pass) {
        Validate.notNull(accountId,"account ID is required");
        Validate.notNull(name,"account name is required");
        Validate.notNull(pass,"account pass is required");

        this.accountId = accountId;
        this.name = name;
        this.pass = pass;
    }

    @Override
    public boolean sameIdentityAs(Account other) {
        return other!=null && accountId.sameValueAs(other.accountId);
    }
}
