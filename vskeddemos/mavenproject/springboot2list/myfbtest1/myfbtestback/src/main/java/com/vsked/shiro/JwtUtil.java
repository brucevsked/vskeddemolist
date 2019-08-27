package com.vsked.shiro;

import com.alibaba.fastjson.JSONObject;
import com.vsked.common.*;
import com.vsked.dao.SysUserDao;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.redis.core.RedisTemplate;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JwtUtil {
	
    public static String create(String subject) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_name", "jcdz");
        claims.put("nick_name", "xiaohuigou");
        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        SecretKey key = generalKey();
        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //nbf: 在签发时间之前该token都是不可用的
                .setNotBefore(now)
                //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setSubject(subject)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, key)
                //设置签发后半小时过期
                .setExpiration(new Date(nowMillis + SysConstant.EXPIRE_TIME * 1000));
        return builder.compact();
    }

    /**
     * 由字符串生成加密key
     *
     * @return SecretKey
     */
    private static SecretKey generalKey() {
        //本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        String stringKey = SysConstant.JWT_SECRET;
        //本地的密码解码[B@152f6e2
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解密jwt
     *
     * @param token 令牌
     * @return Claims
     */
    public static Claims parse(String token) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        //得到DefaultJwtParser
        return Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(key)
                //设置需要解析的jwt
                .parseClaimsJws(token).getBody();
    }

    /**
     * 获取token中的信息
     *
     * @param token 令牌
     * @return String
     */
    public static String getSysUserNameFromToken(String token) {
    	String sysusername="";
        try{
        	log.info("|"+token+"|");
            // 熟悉token的组成部分1:header 2:payload 3.signature
            String[] split = token.split("\\.");
            // 获取payload
            String payload = split[1];
            // 解密payload获得原json信息,后解析为json对象
            JSONObject jsonObject = JSONObject.parseObject(Base64Codec.BASE64URL.decodeToString(payload));
            // 根据jsonObject获去User对象
            Map<String, Object> user = StringTool.jsonToMap(jsonObject.getString("sub"));
            sysusername=(String) user.get("sysusername");
        }catch(Exception e){
        	log.error(e.getMessage(),e);
        }
        return sysusername;
    }


    /**
     * 校验
     *
     * @param request 请求
     * @return Boolean
     */
    @SuppressWarnings("unchecked")
	public static Boolean verify(ServletRequest request, ServletResponse response) {
    	SysUserDao sysUserDao=WebApplicationUtil.getBean(SysUserDao.class, (HttpServletRequest)request);
        RedisTemplate<String, Object> redisTemplate=WebApplicationUtil.getBeanByName("redisTemplate", RedisTemplate.class,(HttpServletRequest)request);
        // 获取头部的token信息
        String token = WebApplicationUtil.getToken(request);
        // 判断token是否为空
        if (StringUtils.isNotBlank(token)) {
            String sysusername = getSysUserNameFromToken(token);
            
            if("".equals(sysusername)) return false;
            
            // 进入redis查询是否还存活
            Object o = redisTemplate.opsForValue().get(SysConstant.REDIS_TOKEN +sysusername);
            if (o != null && token.equals(o.toString())) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                try {
                    // 解析token,过期token则抛出ExpiredJwtException异常
                    parse(token);
                    httpServletResponse.setHeader("token", token);
                } catch (ExpiredJwtException e) {
                	
                	log.error(e.getMessage(),e);
                    // 大于jwt token过期时间小于redis的存活时间,则允许重新签发一个新的token,并重置redis的存活时间
                    Map<String, Object> user = sysUserDao.getSysUserByUserName(sysusername);
                    user.remove("sysuserpwd");
                    user.remove("sysuseraddtime");
                    try {
                        String newToken = create(StringTool.mapToJson(procTokenMap(user)));
                        redisTemplate.opsForValue().set(SysConstant.REDIS_TOKEN + sysusername, token, SysConstant.EXPIRE_TIME * 2, TimeUnit.SECONDS);
                        redisTemplate.opsForValue().set(token,sysusername, SysConstant.EXPIRE_TIME * 2, TimeUnit.SECONDS);
//                		redisTemplate.persist(SysConstant.REDIS_TOKEN + phone);//永不过期
                        httpServletResponse.setHeader("token", newToken);
                		Map<String, String> respDataMap=new HashMap<String, String>();
                		respDataMap.put("token", newToken);
                		String data=StringTool.mapToJson1(respDataMap);
                		String result=RequestResponseTool.getJsonMessage(RespCode.authJwtSucc, RespMsg.authJwtSucc, data);
                		RequestResponseTool.respJson(result, response);
                    } catch (Exception e1) {
                    	log.error(e.getMessage(),e);
                    }
                    
                }
                // 没过期则继续进行流程
                return true;
            }
        }
        return false;
    }

    
    public static Map<String, Object> tokenToMap(String token){
    	Map<String, Object> dataMap=new HashMap<String, Object>();
		try{
			String dataMapStr=parse(token).getSubject();
			dataMap= StringTool.jsonToMap(dataMapStr);
	    }catch(Exception e){
	    	log.error("get userinfo exception",e);
	    }
    	return dataMap;
    }
    
    /**
     * 减少token内容
     * @param userData
     * @return
     */
    public static Map<String, Object> procTokenMap(Map<String, Object> userData){
    	//去除token信息中未使用到的字段以缩短token长度
    	userData.remove("birthday");
    	log.info("|"+userData+"|");
    	return userData;
    	
    }
}
