package com.jat.model.business;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Token {
    private Integer id;
    private String name;
    private Instant expireTime;

    private Boolean isExpire;

    private int defaultExpireTime=2;//默认过期时间 2小时

    public Token(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.expireTime=Instant.now().plus(defaultExpireTime, ChronoUnit.HOURS);
        isExpire=false;
    }

    public Token(Integer id, String name, Instant expireTime) {
        this.id = id;
        this.name = name;
        this.expireTime = getExpireTime();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getExpireTime() {
        checkExpire();
        return expireTime;
    }

    public Boolean getExpire() {
        checkExpire();
        return this.isExpire;
    }

    public void checkExpire(){
        this.isExpire=Instant.now().isAfter(expireTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withLocale(Locale.CHINA).withZone(ZoneId.systemDefault());
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", expireTime=" + formatter.format(expireTime) +
                ", isExpire=" + isExpire +
                "}";
    }
}
