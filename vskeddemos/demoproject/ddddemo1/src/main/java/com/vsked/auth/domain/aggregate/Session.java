package com.vsked.auth.domain.aggregate;

import com.vsked.auth.domain.valueobject.AccountId;
import com.vsked.auth.domain.valueobject.SessionId;
import com.vsked.common.ProjectGlobalSetting;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 后台会话
 */
public class Session {

    private SessionId sessionId;

    private Timestamp createTime;

    private Timestamp expireTime;

    private AccountId accountId;

    public SessionId getSessionId() {
        return sessionId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public static SessionId generateSessionId(Account account){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //设置token过期时间
        Date expirationDate = new Date(nowMillis+ProjectGlobalSetting.jwtExpireTime);
        // 生成密钥
        String key = ProjectGlobalSetting.jwtKey;
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        // 1. 生成 token
        String token = Jwts.builder()
                .setSubject(account.getName())   // 设置主题（声明信息）
                .setIssuedAt(now) //
                .setExpiration(expirationDate)
                .signWith(secretKey)    // 设置安全密钥（生成签名所需的密钥和算法）
                .compact(); // 生成token（1.编码 Header 和 Payload 2.生成签名 3.拼接字符串）

        return new SessionId(token);
    }

    public Session(SessionId sessionId, Timestamp createTime, Timestamp expireTime, AccountId accountId) {
        this.sessionId = sessionId;
        this.createTime = createTime;
        this.expireTime = expireTime;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"sessionId\":\"" + sessionId.toString() +
                "\", \"createTime\":\"" + createTime +
                "\", \"expireTime\":\"" + expireTime +
                "\", \"accountId\":\"" + accountId.toString() +
                "\"}";
    }
}
