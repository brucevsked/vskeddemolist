package com.vsked.common;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密解密工具类
 *
 */
public class CryptoTool {
	public static String charset="utf-8";
	// 默认加密秘钥 AES加密秘钥为约定16位，小于16位会报错
	private static String aesKey="dieyingchongchon";
	private static String aesAlgorithm="AES/CBC/PKCS5Padding";
	
	/**
	 * md5加密
	 * @param content
	 * @return
	 */
	public static String md5(String content){
		return DigestUtils.md5Hex(content);
	}
	
	/**
	 * aes加密,AES/CBC/PKCS5Padding
	 * 使用系统默认key加密
	 * 返回值为base64编码
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String aesEncode(String content) throws Exception{
		String result=aesEncode(content, aesKey);
		return result;
	}
	
	/**
	 * aes加密,AES/CBC/PKCS5Padding
	 * 使用自定义key进行加密
	 * 返回值为base64编码
	 * @param content
	 * @param myAesKey
	 * @return
	 * @throws Exception
	 */
	public static String aesEncode(String content,String myAesKey) throws Exception{
		String result="";
		Key key = new SecretKeySpec(myAesKey.getBytes(charset), "AES");// 格式化key
		Cipher cipher = Cipher.getInstance(aesAlgorithm); // 确定算法
		cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(myAesKey.getBytes(charset)));    // 确定密钥
		byte[] resultByte = cipher.doFinal(content.getBytes(charset));  // 加密
		result=Base64.encodeBase64String(resultByte);
		return result;
	}
	
	/**
	 * aes解密,AES/CBC/PKCS5Padding
	 * 使用系统默认key进行解密
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String aesDecode(String content)throws Exception{
		String rs=aesDecode(content, aesKey);
		return rs;
		
	}
	
	/**
	 * aes解密,AES/CBC/PKCS5Padding
	 * 使用自定义key进行解密
	 * @param content
	 * @param myAesKey
	 * @return
	 * @throws Exception
	 */
	public static String aesDecode(String content,String myAesKey)throws Exception{
		String rs="";
		Key key = new SecretKeySpec(myAesKey.getBytes(charset), "AES");// 格式化key
		Cipher cipher = Cipher.getInstance(aesAlgorithm); // 确定算法
		cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(myAesKey.getBytes(charset)));    // 确定密钥
		byte[] bytesContent = Base64.decodeBase64(content);
		byte[] resultByte = cipher.doFinal(bytesContent);  // 解密
		rs=new String(resultByte, charset);		
		return rs;
		
	}

	/**
	 * base64 encode
	 * @param s
	 * @return
	 */
	public static String base64Encode(String s) throws Exception {
		return Base64.encodeBase64String(s.getBytes(charset));
	}

	public static byte[] baseEncodeByte(String s) throws Exception {
		return Base64.encodeBase64(s.getBytes(charset));
	}

	/**
	 * base encode
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static String base64Decode(String s) throws Exception {
		return new String(Base64.decodeBase64(s),charset);
	}

	public static byte[] base64DecodeByte(String s){
		return Base64.decodeBase64(s);
	}


}
