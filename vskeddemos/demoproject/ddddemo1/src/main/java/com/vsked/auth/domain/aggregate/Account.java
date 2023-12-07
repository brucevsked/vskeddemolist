package com.vsked.auth.domain.aggregate;

import com.vsked.auth.domain.valueobject.AccountId;
import com.vsked.auth.web.VO.AccountLoginInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

    private static final Logger log = LoggerFactory.getLogger(Account.class);

    private AccountId accountId;

    /**
     * 账户名
     */
    private String name;

    /**
     * 加密后密码
     */
    private String passWord;

    public AccountId getAccountId() {
        return accountId;
    }

    public Account(AccountId accountId, String name, String passWord) {
        this.accountId = accountId;
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void login(AccountLoginInfoVO accountLoginInfoVO){
        if(passWord.equals(accountLoginInfoVO.getPassword())){
            log.debug("login success");
        }else{
            log.debug("login fail");
        }
    }


}
