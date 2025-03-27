package com.jat.system.model.account;

import com.jat.repository.model.AccountPO;

/**
 * 账户 1
 */
public class Account {

    private AccountId id;
    private AccountName name;
    private AccountPass password;

    public Account(AccountId platformAccountId, AccountName platformAccountName, AccountPass platformAccountPassword) {
        this.id= platformAccountId;
        this.name = platformAccountName;
        this.password = platformAccountPassword;
    }

    public Account(AccountName name, AccountPass password) {
        this.name = name;
        this.password = password;
    }

    public Account(AccountName platformAccountName, AccountPass platformAccountPassword, AccountPass passwordAgain) {
        platformAccountPassword.validAgainPassword(passwordAgain.getPassword());
        this.name = platformAccountName;
        this.password = platformAccountPassword;
    }

    public Account(AccountName platformAccountName, AccountPass platformAccountPasswordOld, AccountPass platformAccountPasswordNew, AccountPass passwordAgain){
        platformAccountPasswordNew.validAgainPassword(passwordAgain.getPassword());
        platformAccountPasswordNew.validOldPassword(platformAccountPasswordOld.getPassword());
        this.name = platformAccountName;
        this.password = platformAccountPasswordNew;
    }


    public AccountId getId() {
        return id;
    }

    public AccountName getName() {
        return name;
    }

    public AccountPass getPassword() {
        return password;
    }

    public static void checkNotExist(Account platformAccount){
        if(platformAccount ==null){
            throw new IllegalArgumentException("账户名不经存在！");
        }
    }

    public static void checkIsExist(AccountPO accountPO){
        if(accountPO !=null){
            throw new IllegalArgumentException("账户名["+ accountPO.getName()+"]已经存在！");
        }
    }

    public void validatePassword(AccountPass oldPwd){
        if(!this.getPassword().getPassword().equals(oldPwd.getEncodePassword())){
            throw new IllegalArgumentException("旧密码输入错误！");
        }
    }

    public void changePassword(AccountPass oldPwd,AccountPass newPwd){
        validatePassword(oldPwd);
        this.password=newPwd;
    }

    public void resetPassword(AccountPass newPwd){
        this.password=newPwd;
    }

    public static Account poToBo(AccountPO po){
        if(po==null){
            throw new IllegalArgumentException("无账号信息！");
        }
        AccountId id=new AccountId(po.getId());
        AccountName name=new AccountName(po.getName());
        AccountPass pass=new AccountPass(po.getPass());
        return new Account(id,name,pass);
    }

    public AccountPO boToPo(Integer isDel){
        Integer id=null;
        if(this.getId()!=null){
            id=this.getId().getId();
        }
        return new AccountPO(id,this.getName().getName(),this.getPassword().getEncodePassword(),isDel);
    }
    
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"accountName\":\"" + name +"\""+
                ", \"password\":\"" + password +"\""+
                "}";
    }
	
}
