package com.jat.bo;

/**
 * 账户 1
 */
public class PlatformAccount {

    private PlatformAccountId id;
    private PlatformAccountName name;
    private PlatformAccountPassword password;

    public PlatformAccount(Long accountIdPar, String accountNameStr, String passwordStr) {
        PlatformAccountId platformAccountId =new PlatformAccountId(accountIdPar);
        PlatformAccountName platformAccountName =new PlatformAccountName(accountNameStr);
        PlatformAccountPassword platformAccountPassword =new PlatformAccountPassword(passwordStr);
        this.id= platformAccountId;
        this.name = platformAccountName;
        this.password = platformAccountPassword;
    }

    public PlatformAccount(String accountNameStr, String passwordStr, String passwordAgainStr) {
        PlatformAccountName platformAccountName =new PlatformAccountName(accountNameStr);
        PlatformAccountPassword platformAccountPassword =new PlatformAccountPassword(passwordStr);
        PlatformAccountPassword passwordAgain=new PlatformAccountPassword(passwordAgainStr);
        platformAccountPassword.validAgainPassword(passwordAgain.getPassword());
        this.name = platformAccountName;
        this.password = platformAccountPassword;
    }

    public PlatformAccount(String accountNameStr, String passwordOldStr, String passwordNewStr, String passwordNewAgainStr){
        PlatformAccountName platformAccountName =new PlatformAccountName(accountNameStr);
        PlatformAccountPassword platformAccountPasswordOld =new PlatformAccountPassword(passwordOldStr);
        PlatformAccountPassword platformAccountPasswordNew =new PlatformAccountPassword(passwordNewStr);
        PlatformAccountPassword passwordAgain=new PlatformAccountPassword(passwordNewAgainStr);
        platformAccountPasswordNew.validAgainPassword(passwordAgain.getPassword());
        platformAccountPasswordNew.validOldPassword(platformAccountPasswordOld.getPassword());
        this.name = platformAccountName;
        this.password = platformAccountPasswordNew;
    }

    public void changePassword(String passwordNewStr){
        PlatformAccountPassword platformAccountPasswordNew =new PlatformAccountPassword(passwordNewStr);
        this.password= platformAccountPasswordNew;
    }

    public void setId(PlatformAccountId id) {
        this.id = id;
    }

    public PlatformAccountId getId() {
        return id;
    }

    public PlatformAccountName getName() {
        return name;
    }

    public PlatformAccountPassword getPassword() {
        return password;
    }

    public static void checkNotExist(PlatformAccount platformAccount){
        if(platformAccount ==null){
            throw new IllegalArgumentException("账户名不经存在！");
        }
    }

    public static void checkIsExist(PlatformAccount platformAccount){
        if(platformAccount !=null){
            throw new IllegalArgumentException("账户名["+ platformAccount.getName()+"]已经存在！");
        }
    }

    public void validatePassword(String accountPasswordOld){
        PlatformAccountPassword oldPwd=new PlatformAccountPassword(accountPasswordOld);
        if(!this.getPassword().getPassword().equals(oldPwd.getPassword())){
            throw new IllegalArgumentException("旧密码输入错误！");
        }
    }
    
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"name\":\"" + name +"\""+
                ", \"password\":\"" + password +"\""+
                "}";
    }
	
}
