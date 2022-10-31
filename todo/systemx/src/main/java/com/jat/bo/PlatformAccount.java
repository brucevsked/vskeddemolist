package com.jat.bo;

/**
 * 账户 1
 */
public class PlatformAccount {

    private PlatformAccountId id;
    private PlatformAccountName name;
    private PlatformAccountPassword password;

    public PlatformAccount(Long accountId, String accountName, String password) {
        this.id= new PlatformAccountId(accountId);
        this.name = new PlatformAccountName(accountName);
        this.password = new PlatformAccountPassword(password);
    }

    public PlatformAccount(Long accountId,String accountName, String passwordStr, String passwordAgainStr) {
        this.id= new PlatformAccountId(accountId);
        this.name = new PlatformAccountName(accountName);
        PlatformAccountPassword platformAccountPassword =new PlatformAccountPassword(passwordStr);
        PlatformAccountPassword passwordAgain=new PlatformAccountPassword(passwordAgainStr);
        platformAccountPassword.validAgainPassword(passwordAgain.getPassword());
        this.password = platformAccountPassword;
    }

    public PlatformAccount(Long accountId,String accountName, String passwordOldStr, String passwordNewStr, String passwordNewAgainStr){
        this.id= new PlatformAccountId(accountId);
        this.name = new PlatformAccountName(accountName);
        PlatformAccountPassword platformAccountPasswordOld =new PlatformAccountPassword(passwordOldStr);
        PlatformAccountPassword platformAccountPasswordNew =new PlatformAccountPassword(passwordNewStr);
        PlatformAccountPassword passwordAgain=new PlatformAccountPassword(passwordNewAgainStr);
        platformAccountPasswordNew.validAgainPassword(passwordAgain.getPassword());
        platformAccountPasswordNew.validOldPassword(platformAccountPasswordOld.getPassword());
        this.password = platformAccountPasswordNew;
    }

    public void changePassword(String passwordNew){
        this.password= new PlatformAccountPassword(passwordNew);
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

    public void isExist(PlatformAccount platformAccount){
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
