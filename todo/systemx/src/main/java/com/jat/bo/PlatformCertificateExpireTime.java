package com.jat.bo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PlatformCertificateExpireTime {

    private LocalDateTime dateTime;
    private int defaultExpireTime=1000*60*60*24*1;//1000毫秒,60秒,60分,24小时,1天

    public PlatformCertificateExpireTime() {
        LocalDateTime currentDateTime=LocalDateTime.now();
        currentDateTime.plus(defaultExpireTime, ChronoUnit.MILLIS);
        this.dateTime=currentDateTime;
    }

    public PlatformCertificateExpireTime(LocalDateTime dateTime) {
        if(dateTime==null){
            throw new IllegalArgumentException("证书过期时间不能为空！");
        }

        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String toString() {
        return ""+dateTime;
    }
}
