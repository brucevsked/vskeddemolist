package com.jat.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.jat.exception.ConfigException;
import com.jat.model.IJwtAble;
import com.jat.service.IJwtUserService;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.redis.Redis;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class JwtKit {

    private static final Logger log = LoggerFactory.getLogger(JwtKit.class);

    public static String header = "Authorization";  // 默认请求头标识符
    public static String tokenPrefix = "";    // 默认token前缀
    public static String secret = "default";         // 默认私钥
    public static Long expiration = 604800L;          // 默认失效时间(秒)
    public static IJwtUserService userService = null;//  需要注入的服务参数

    private static final String CLAIM_KEY_USERID = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    public static final String userIdKey="system:user:userid";

	public static Prop prop = PropKit.use("db.txt");


    /**
     * 重构缓存
     */
    public static void storeReset() {
    }


    /**
     * 使用用户名与密码换取token
     * @param userName 用户名
     * @param password 密码
     * @return token
     */
    public static String getToken(String userName, String password) {
    	if (userService == null)
            throw new ConfigException("userService", "空/null");
        IJwtAble user = userService.login(userName, password);
        if (user == null) return null;

        // 用userId创建token
        String token = generateToken(user.getUserId());
        // 构建服务器端储存对象
        Redis.use(prop.get("cacheName")).set(userIdKey+":"+user.getUserId(),user);

        return tokenPrefix + token;
    }

    public static String getToken(HttpServletRequest request){
        return request.getHeader("token");
    }

    public static IJwtAble getUser(String token){
        String userId=JwtKit.getJwtUserId(token);
        IJwtAble user=Redis.use(prop.get("cacheName")).get(userIdKey+":"+userId);
        return user;
    }


    public static void removeToken(String token){
        String userId=JwtKit.getJwtUserId(token);
        if(userId!=null){
            String myKey=userIdKey+":"+userId;
            Redis.use(prop.get("cacheName")).del(myKey);
        }

    }


    /**
     * 从用户Token中获取用户名信息
     *
     * @param authToken 令牌
     * @return userId
     */
    public static String getJwtUserId(String authToken) {
        String jwtUser = null;
        try {
            final Claims claims = getClaimsFromToken(authToken);
            jwtUser = claims != null ? claims.getSubject() : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jwtUser;
        }
    }

    public static String getJwtUserIdBy(HttpServletRequest request){
        String token=JwtKit.getToken(request);
        //log.info("{}",token);
        return JwtKit.getJwtUserId(token);
    }

    /**
     * 获取 getJwtBean 对象
     * @param userId 用户编号
     * @param created 创建日期
     * @return IJwtAble
     */
    public static IJwtAble getJwtBean(String userId, Date created) {
        IJwtAble jwtBean = null;
        try {
            jwtBean = (IJwtAble) Redis.use(prop.get("cacheName")).get(userIdKey+":"+userId);
            if (created == null || jwtBean == null || created.before(jwtBean.getLastModifyPasswordTime()))/* 如果创建时间在修改密码之前 **/ {
                jwtBean = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwtBean;
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
