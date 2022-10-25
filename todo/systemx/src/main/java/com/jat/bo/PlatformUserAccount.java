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

    @Override
    public String toString() {
        return "{" +
                "platformUser=" + platformUser +
                ", platformAccount=" + platformAccount +
                '}';
    }
}
