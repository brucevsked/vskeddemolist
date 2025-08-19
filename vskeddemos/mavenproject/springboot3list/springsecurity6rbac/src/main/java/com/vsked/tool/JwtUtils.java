package com.vsked.tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtils {

    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    // 密钥（建议使用更安全的随机生成方式，或从配置文件读取）
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("yunze521everyonelovethiscompanyyoucanfindsome566666manatofficegood".getBytes());
    private static final long EXPIRATION =  8 * 60 * 60 * 1000; // 8小时的毫秒数;

    /**
     * 生成 JWT
     */
    public static String generateToken(String username,String userId) {
        log.info("generateToken: username={} userId={}", username, userId);
        return Jwts.builder()
                .subject(username)
                .claim("userId", userId) // 将用户 ID 放入 Token
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String generateToken(String username) {
        log.info("generateToken: username={} ", username);
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * 解析用户名
     */
    public static String parseUsername(String token) {
        return parseClaims(token).getPayload().getSubject();
    }

    /**
     * 解析用户 ID
     */
    public static String parseUserId(String token) {
        return parseClaims(token).getPayload().get("userId", String.class);
    }

    /**
     * 解析完整的 Claims（可用于获取更多自定义信息）
     */
    private static Jws<Claims> parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token);
    }

    /**
     * 校验 Token 是否有效
     */
    public static boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}