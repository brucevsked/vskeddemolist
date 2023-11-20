package com.vsked.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.vsked.common.CryptoTool;

/**
 * 解密步骤如下：
 * （1）对加密串A做base64解码，得到加密串B
 * （2）对商户key做md5，得到32位小写key* ( key设置路径：微信商户平台-->账户设置-->API安全-->密钥设置 )
 * （3）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
 * @author vsked
 *
 */
public class WxCryptoToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(WxCryptoToolTest.class);
	
	//3mA7Ei68b+AgV9cqVyyOCcHJpCXn8Vnv58j6UqzfRCYyzi/A4/XeIDTQWEAEXjdvzz6RY4YIQDT+hnwSJ7kB1Rkj0avZrSM/NppO6B33tUH3iQMXphR4mHYhARF5vELtjwXmNt9jk7bWaCF76MGJDAC0PgXmO6SRMK6mOX7wVNWua9Epzkye2NwGnmkjO4nELPs881EnwfQeZ8kKZ42+aGM9VhalnGBhsOV+Yn/7YqSCbNrEfYXIYGp6k+fvrAqmlVtOu1VRDBsUPG4mlGsSYTZwBzNJnkmU3Vap88U0tHoq1YOOiwyqRcxcqp+v9zV4yy33ylF8cfKPZQoK4JwqtZhXZOY9UNqT4J8lAL0xSmDP3SP0Of2sNQCWPaaG9zqCUkk1Zyv5azuz0Fp8kP/1vnoiOnegHonPvLoC29V95c8bOH3549q1s6ZQUySdlvJC72gDtek9QLVzMh8TxAMEe8YHKzxJaFkaaJ4Q24zhV8+X9DQlFR5/sTo4JQDjDmY8sI3D3R2+JWjeizsyIqrIu1q1NenG5vVTz9TKcWH/7ODTavaWq/agWX0IVl81nY55Zocumh2C1EtrW+/iMOJ7WnSoEqZdKoa/k8GInb8FAdq/hfITyOfI9jyBQOU/PIroAu+7x5xVUyznzgYTmWaNQ+SN3k5NZMSRtjrQtgftfgbk+P5YVyoAxVQxaTr3TDJ0kTxjW85B2EehdwxqLMie0wuqmmkbZYFISdLrJZIrfQfByaQl5/FZ7+fI+lKs30QmKZw+x441vNhA8qTx0CGNbkZBV/4chCR6WD84h6o7SKpo8hrjaq4FjceQn2s1AzpmmWFgryZdpxwjRvu2xtpsaBfR7r8l2NXvCYcvYlIMuBofnrsmG1xuzUsZEXK6A7WYRLqw3PlhILmXu2sySM/+BXotpy4jBejhcNFXU/ZHP0vWI3feOc7vTEAFDya9ytqZzC7QCcgiGQnox8sDcWbf5QZxibiLEvl0RM0v5YjUTh9W9jsFWY8fj21vLdp5n12eSOs7h826TD6Iaobh6cSE0Wkt1VnJpshgL8S65JjBaiPEAOBkmQd7IUEVBFff4WtsMLONHkcFWGWMm1Sb0UG/4rHKfuf73WjFk1628e902mQ=

	@Test
	public void testRefoundDecode() throws Exception {
		String paternerKey="BDhYY9BerZv7v6Y8HpqQJbzk1iEBWeLu";
		String reqInfo="3mA7Ei68b+AgV9cqVyyOCcHJpCXn8Vnv58j6UqzfRCYyzi/A4/XeIDTQWEAEXjdvzz6RY4YIQDT+hnwSJ7kB1Rkj0avZrSM/NppO6B33tUH3iQMXphR4mHYhARF5vELtjwXmNt9jk7bWaCF76MGJDAC0PgXmO6SRMK6mOX7wVNWua9Epzkye2NwGnmkjO4nELPs881EnwfQeZ8kKZ42+aGM9VhalnGBhsOV+Yn/7YqSCbNrEfYXIYGp6k+fvrAqmlVtOu1VRDBsUPG4mlGsSYTZwBzNJnkmU3Vap88U0tHoq1YOOiwyqRcxcqp+v9zV4yy33ylF8cfKPZQoK4JwqtZhXZOY9UNqT4J8lAL0xSmDP3SP0Of2sNQCWPaaG9zqCUkk1Zyv5azuz0Fp8kP/1vnoiOnegHonPvLoC29V95c8bOH3549q1s6ZQUySdlvJC72gDtek9QLVzMh8TxAMEe8YHKzxJaFkaaJ4Q24zhV8+X9DQlFR5/sTo4JQDjDmY8sI3D3R2+JWjeizsyIqrIu1q1NenG5vVTz9TKcWH/7ODTavaWq/agWX0IVl81nY55Zocumh2C1EtrW+/iMOJ7WnSoEqZdKoa/k8GInb8FAdq/hfITyOfI9jyBQOU/PIroAu+7x5xVUyznzgYTmWaNQ+SN3k5NZMSRtjrQtgftfgbk+P5YVyoAxVQxaTr3TDJ0kTxjW85B2EehdwxqLMie0wuqmmkbZYFISdLrJZIrfQfByaQl5/FZ7+fI+lKs30QmKZw+x441vNhA8qTx0CGNbkZBV/4chCR6WD84h6o7SKpo8hrjaq4FjceQn2s1AzpmmWFgryZdpxwjRvu2xtpsaBfR7r8l2NXvCYcvYlIMuBofnrsmG1xuzUsZEXK6A7WYRLqw3PlhILmXu2sySM/+BXotpy4jBejhcNFXU/ZHP0vWI3feOc7vTEAFDya9ytqZzC7QCcgiGQnox8sDcWbf5QZxibiLEvl0RM0v5YjUTh9W9jsFWY8fj21vLdp5n12eSOs7h826TD6Iaobh6cSE0Wkt1VnJpshgL8S65JjBaiPEAOBkmQd7IUEVBFff4WtsMLONHkcFWGWMm1Sb0UG/4rHKfuf73WjFk1628e902mQ=";
		//第一步Base64解码
		byte[] base64ByteArr = CryptoTool.base64Decode(reqInfo);
		
		//第二步替换加密算法支持文件 
		//如果是jdk8，可能会遇到安全目录下有 policy文件夹的情况，拿作者的电脑举例，
		//先备份 local_policy.jar US_export_policy.jar 替换为https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html下载到的包
		//替换 jre\lib\security\policy\limited 下面两个文件
		
		String paternerKeyMd5=CryptoTool.md5Encode(paternerKey);
		
		//第三步
		String result=WxCryptoTool.decryptData(paternerKeyMd5, base64ByteArr);
		log.debug("{}",result);
		
		
	}
}
