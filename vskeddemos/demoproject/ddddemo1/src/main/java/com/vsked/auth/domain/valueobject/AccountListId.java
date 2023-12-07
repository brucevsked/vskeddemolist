package com.vsked.auth.domain.valueobject;

/**
 * 账户列表唯一标识
 */
public class AccountListId {

    private Long accountListId;

    public AccountListId(Long accountListId) {
        this.accountListId = accountListId;
    }

    public Long getAccountListId() {
        return accountListId;
    }
}
