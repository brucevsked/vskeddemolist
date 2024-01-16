package com.jat.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;


/**
 *
 */
public class JWTTest {

	private static final Logger log = LoggerFactory.getLogger(JWTTest.class);

	@Test
	public void jwtTest() {
		log.info("----------start test");
		//生成JWT的时间
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Date expirationDate = new Date(nowMillis+60 * 60 * 24*1000);//1天
		// 生成密钥
		String key = "tianxiayingxiongchuwobeijiushibufu110";
		SecretKey secretKey = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS256.getJcaName());

		log.info("----------生成jwt测试");
		// 1. 生成 token
		String token = Jwts.builder()
				.setSubject("JSON Web Token666")   // 设置主题（声明信息）
				.setIssuedAt(now) //
				.setExpiration(expirationDate)
				.signWith(secretKey)    // 设置安全密钥（生成签名所需的密钥和算法）
				.compact(); // 生成token（1.编码 Header 和 Payload 2.生成签名 3.拼接字符串）
		log.debug(token);

		log.info("----------验证jwt测试");
		try {
			Jwts.parserBuilder()
					.setSigningKey(secretKey) // <----
					.build()
					.parseClaimsJws(token);
			log.debug("token验证成功");
		}catch(Exception e){
			log.error(e.getMessage(),e);
			log.debug("token验证失败"+e.getMessage());
		}
		log.info("----------解析jwt测试");
		Claims body=Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
		log.debug(body.getSubject());

	}
	
}
