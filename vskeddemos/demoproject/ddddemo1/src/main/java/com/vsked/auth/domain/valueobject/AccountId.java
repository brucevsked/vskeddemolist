package com.vsked.auth.domain.valueobject;

/**
 * 账户唯一标识
 */
public class AccountId {

    private Long accountId;

    public AccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return  accountId+"";
    }
}
