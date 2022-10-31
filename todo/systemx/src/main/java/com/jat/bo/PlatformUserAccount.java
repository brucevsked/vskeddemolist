package com.jat.bo;

public class PlatformUserAccount {

    private PlatformUser platformUser;
    private PlatformAccount platformAccount;

    public PlatformUserAccount(PlatformUser platformUser, PlatformAccount platformAccount) {
        if(platformUser ==null){
            throw new IllegalArgumentException("用户不能为空！");
        }
        if(platformAccount ==null){
            throw new IllegalArgumentException("账号不能为空！");
        }
        this.platformUser = platformUser;
        this.platformAccount = platformAccount;
    }

    public PlatformUser getUser() {
        return platformUser;
    }

    public PlatformAccount getAccount() {
        return platformAccount;
    }

    public static void isNotExist(PlatformUserAccount platformUserAccount){
        if(platformUserAccount==null){
            throw new IllegalArgumentException("账号不存在！");
        }
    }

    public void login(PlatformAccount account){
        if(!this.platformAccount.getPassword().getPassword().equals(account.getPassword().getPassword())){
            throw new IllegalArgumentException("账号密码输入错误！");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "platformUser=" + platformUser +
                ", platformAccount=" + platformAccount +
                '}';
    }
}
