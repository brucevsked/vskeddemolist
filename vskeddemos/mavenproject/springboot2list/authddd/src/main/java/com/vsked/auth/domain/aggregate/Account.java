package com.vsked.auth.domain.aggregate;

import com.vsked.auth.domain.valueobject.AccountId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="account")
public class Account implements Serializable {

    @Id
    private AccountId accountId;


    public Account(AccountId accountId) {
        this.accountId = accountId;
    }
}
