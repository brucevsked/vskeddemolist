package com.jat.bo;

public class PlatformUserCertificate {
    private PlatformUser platformUser;
    private PlatformCertificate platformCertificate;

    public PlatformUserCertificate(PlatformUser platformUser, PlatformCertificate platformCertificate) {
        if(platformUser ==null){
            throw new IllegalArgumentException("用户不能为空！");
        }
        if(platformCertificate ==null){
            throw new IllegalArgumentException("登录证书不能为空！");
        }
        this.platformUser = platformUser;
        this.platformCertificate = platformCertificate;
    }

    public PlatformUser getPlatformUser() {
        return platformUser;
    }

    public PlatformCertificate getPlatformCertificate() {
        return platformCertificate;
    }
}
