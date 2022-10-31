package com.jat.bo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PlatformCertificate {

    private PlatformCertificateId id;
    private PlatformCertificateExpireTime expireTime;

    public PlatformCertificate(Long id, LocalDateTime expireTime) {
        this.id = new PlatformCertificateId(id);
        this.expireTime = new PlatformCertificateExpireTime(expireTime);
    }

    public static void checkNotExist(PlatformCertificate platformCertificate){
        if(platformCertificate ==null){
            throw new IllegalArgumentException("登录证书不存在，请检查登录状态或证书编号！");
        }
    }

    public void checkIsExpire(){
        if(isExpire()){
            throw new IllegalArgumentException("登录会话已过期，请重新登录！");
        }
    }


    /**
     * 证书是否已过期
     * @return true过期,false未过期
     */
    public Boolean isExpire(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        LocalDateTime expireTime=getExpireTime().getDateTime();
        if(expireTime.isBefore(currentDateTime)){
            return true;
        }
        return false;
    }

    /**
     * 证书立即过期
     * 将证书时间设置为10秒前，让证书过期
     */
    public void expireImmediate(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        currentDateTime.minus(10, ChronoUnit.SECONDS);
        this.expireTime=new PlatformCertificateExpireTime(currentDateTime);
    }

    public PlatformCertificateId getId() {
        return id;
    }

    public PlatformCertificateExpireTime getExpireTime() {
        return expireTime;
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"expireTime\":\"" + expireTime +
                "\"}";
    }
}
