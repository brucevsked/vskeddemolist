package com.jat.system.model;

import java.util.Date;

/**
 * 用户凭证
 */
public class Certificate {

    private Long id;
    private Date expireTime;

    public Long getId() {
        return id;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 证书是否已过期
     * @return true过期,false未过期
     */
    public Boolean isExpire(){
        Date dateNow=new Date();
        Date expireDateTime=getExpireTime();
        return expireDateTime.before(dateNow);
    }

    public Boolean isNeedRefresh(){
        Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;
        Date dateNow=new Date();
        Date expireDateTime=getExpireTime();
        if(expireDateTime.getTime()-dateNow.getTime()<=MILLIS_MINUTE_TEN){
            return true;
        }
        return false;
    }

    public Certificate(Long id, Date expireTime) {
        this.id = id;
        this.expireTime = expireTime;
    }

    public Certificate() {
        this.expireTime = new Date();
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"expireTime\":\"" + expireTime +"\""+
                "}";
    }
}
