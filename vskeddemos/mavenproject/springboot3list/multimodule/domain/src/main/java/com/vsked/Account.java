package com.vsked;


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

    
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"accountName\":\"" + name +"\""+
                ", \"password\":\"" + password +"\""+
                "}";
    }
	
}
