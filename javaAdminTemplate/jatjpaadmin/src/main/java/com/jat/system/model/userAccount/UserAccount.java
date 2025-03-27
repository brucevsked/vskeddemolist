package com.jat.system.model.userAccount;

import com.jat.repository.model.AccountPO;
import com.jat.repository.model.UserAccountPO;
import com.jat.repository.model.UserPO;
import com.jat.system.model.account.Account;
import com.jat.system.model.user.User;

public class UserAccount {
    private User user;
    private Account account;

    public UserAccount(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public void login(Account account){
        boolean isLogin=false;

        if(this.account.getPassword().getPassword().equals(account.getPassword().getEncodePassword())){
            if(this.user.getState().getState()==0){
                isLogin=true;
            }
        }

        if(isLogin==false){
            throw new IllegalArgumentException("登录失败，用户密码输入错误或用户已被停用！");
        }

    }

    public static UserAccount poToBo(UserAccountPO po){
        if(po==null){
            throw new IllegalArgumentException("无用户账号信息！");
        }

        User user=User.poToBo(po.getUser());
        Account account=Account.poToBo(po.getAccount());
        return new UserAccount(user,account);
    }

    public UserAccountPO boToPo(Integer isDel){
        User user=getUser();
        UserPO userPO=user.boToPo(isDel);
        Account account=getAccount();
        AccountPO accountPO=account.boToPo(isDel);
        return new UserAccountPO(userPO,accountPO);
    }

    public User getUser() {
        return user;
    }

    public Account getAccount() {
        return account;
    }
}
