package com.vsked.bookborrow.applicationservice;

import com.vsked.bookborrow.web.VO.auth.login.AccountNamePasswordVO;

public class AccountLoginService {

    public void nameAndPasswordLogin(AccountNamePasswordVO accountNamePasswordVO){
        //1根据用户名查找用户
        //AccountPO account=acountrepository.findOne(specfication findByName);
        //工厂通过PO创建domain object
        //Account account=AccountFactory.getAccountFromPO(account);
        //account.accountLogin(accountNamePasswordVO);
        //基础设施层写登录日志
    }
}
