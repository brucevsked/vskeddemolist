package com.jat.config;

import com.jat.controller.model.UserView;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtKit {

    private static final Logger log = LoggerFactory.getLogger(JwtKit.class);

    public static String header = "Authorization";  // 默认请求头标识符
    public static String tokenPrefix = "";    // 默认token前缀
    public static String secret = "goodGameForHere";         // 默认私钥
    public static Long expiration = 604800L;          // 默认失效时间(秒)

    private static final String CLAIM_KEY_USERID = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    public static final String userIdKey="system:user:userid";

    @Value("${cache.cacheName}")
    public String cacheName;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public JwtKit() {
    }

    /**
     * 重构缓存
     */
    public static void storeReset() {
    }


    /**
     * 使用用户名与密码换取token
     * @return token
     */
    public String getToken(UserView user) {

        String userId=user.getId()+"";
        // 用userId创建token
        String token = generateToken(userId);
        // 构建服务器端储存对象
        redisTemplate.opsForValue().set(userIdKey+":"+userId,user);

        return tokenPrefix + token;
    }

    public static String getToken(HttpServletRequest request){
        return request.getHeader("token");
    }

    /**
     * 从用户Token中获取用户名信息
     *
     * @param authToken 令牌
     * @return userId
     */
    public static Integer getJwtUserId(String authToken) {
        Integer jwtUser = null;
        try {
            final Claims claims = getClaimsFromToken(authToken);
            jwtUser = claims != null ? Integer.valueOf(claims.getSubject()) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jwtUser;
        }
    }

    public Integer getJwtUserIdBy(HttpServletRequest request){
        String token=JwtKit.getToken(request);
        //log.info("{}",token);
        return JwtKit.getJwtUserId(token);
    }

    public UserView getUser(HttpServletRequest request){
        Integer userId=getJwtUserIdBy(request);
        Object redisObject=redisTemplate.opsForValue().get(userIdKey+":"+userId);
        log.debug("{}",redisObject);
        return (UserView) redisObject;
    }

    public void removeToken(HttpServletRequest request){
        Integer userId=getJwtUserIdBy(request);
        redisTemplate.delete(userIdKey+":"+userId);
    }


    /**
     * 获取Token的过期日期
     *
     * @param token 令牌
     * @return Date
     */
    public static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 获取用户Token的创建日期
     *
     * @param authToken 令牌
     * @return Date
     */
    public static Date getCreatedDateFormToken(String authToken) {
        Date creatd;
        try {
            final Claims claims = getClaimsFromToken(authToken);
            creatd = new Date((Long) claims.get(CLAIM_KEY_CREATED)); // 把时间戳转化为日期类型
        } catch (Exception e) {
            creatd = null;
        }

        return creatd;
    }

    /**
     * 判断Token是否已经过期
     *
     * @param token 令牌
     * @return boolean
     */
    private static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 将Token信息解析成Claims
     *
     * @param token 令牌
     * @return Claims
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 根据用户信息生成Token
     *
     * @param userId 用户编号
     * @return string
     */
    private static String generateToken(String userId) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(CLAIM_KEY_USERID, userId);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 根据Claims信息来创建Token
     *
     * @param claims 签发信息
     * @return s
     */
    private static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成令牌的过期日期
     *
     * @return date
     */
    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


}
