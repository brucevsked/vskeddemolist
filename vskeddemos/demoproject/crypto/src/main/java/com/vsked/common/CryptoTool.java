package com.vsked.common;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *  加密解密工具类  <br>
 *  base64Encode base64编码方法  <br>
 *  base64Decode base64解码方法  <br>
 *  md5Encode md5加密方法  <br>
 *
 *
 */
public class CryptoTool {

	/**
	 *进行加密或解密时默认编码utf-8  <br>
	 */
	public static final String charset="utf-8";
	/**
	 * AES/CBC/PKCS5Padding加密时  <br>
	 * 默认加密秘钥 AES加密秘钥为约定16位，小于16位会报错
	 */
	private static final String aesCBCPKCS5Key="vskyuelaiyuehaoa";
	private static final String aesCBCPKCS5Algorithm="AES/CBC/PKCS5Padding";

	/**
	 * AES/GCM/NoPadding加密时  <br>
	 * 默认加密秘钥 AES加密秘钥为约定32位，小于32位会报错
	 */
//	private static final String aesGCMNoPaddingKey="vskyuelaiyuehaoavskyuelaiyuehaoa";
	private static final String aesGCMNoPaddingAlgorithm="AES/GCM/NoPadding";

	/**
	 * base64编码操作
	 * @param encodeContent 传入需要进行编码的比特数组(可以由字符串转换而来)
	 * @return 返回进行base64编码后字符串
	 */
	public static String base64Encode(byte[] encodeContent) {
		return Base64.encodeBase64String(encodeContent);
	}

	/**
	 * base64解码操作
	 * @param decodeContent 传入需要进行解码的字符串
	 * @return 返回进行base64解码后字符串
	 */
	public static byte[] base64Decode(String decodeContent){
		return Base64.decodeBase64(decodeContent);
	}
	
	/**
	 * md5加密
	 * @param content 需要加密的内容
	 * @return string 返回md5加密后字符串
	 */
	public static String md5Encode(String content){
		return DigestUtils.md5Hex(content);
	}
	
	/**
	 * aes加密,AES/CBC/PKCS5Padding
	 * 使用系统默认key加密
	 * @param content 需要进行AES/CBC/PKCS5Padding加密的字符串
	 * @return 返回进行AES/CBC/PKCS5Padding加密结果并进行base64编码
	 * @throws Exception 本方法可能会产生异常,需要上层进行异常捕捉
	 */
	public static String aesCBCPKCS5Encode(String content) throws Exception{
		return aesCBCPKCS5Encode(content, aesCBCPKCS5Key);
	}
	
	/**
	 * aes加密,AES/CBC/PKCS5Padding
	 * 使用自定义key进行加密
	 * 返回值为base64编码
	 * @param content AES/CBC/PKCS5Padding加密
	 * @param myAesKey 加密秘钥 AES加密秘钥为约定16位，小于16位会报错
	 * @return 返回进行AES/CBC/PKCS5Padding加密结果并进行base64编码
	 * @throws Exception 本方法可能会产生异常,需要上层进行异常捕捉
	 */
	public static String aesCBCPKCS5Encode(String content,String myAesKey) throws Exception{
		Key key = new SecretKeySpec(myAesKey.getBytes(charset), "AES");// 格式化key
		Cipher cipher = Cipher.getInstance(aesCBCPKCS5Algorithm); // 确定算法
		cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(myAesKey.getBytes(charset)));    // 确定密钥
		byte[] resultByte = cipher.doFinal(content.getBytes(charset));  // 加密
		return base64Encode(resultByte);
	}
	
	/**
	 * aes解密,AES/CBC/PKCS5Padding
	 * 使用系统默认key进行解密
	 * @param content 需要AES/CBC/PKCS5Padding解密内容
	 * @return 返回进行base64解码并进行AES/CBC/PKCS5Padding解密结果字符串
	 * @throws Exception 本方法可能会产生异常,需要上层进行异常捕捉
	 */
	public static String aesCBCPKCS5Decode(String content)throws Exception{
		return aesCBCPKCS5Decode(content, aesCBCPKCS5Key);
	}
	
	/**
	 * aes解密,AES/CBC/PKCS5Padding
	 * 使用自定义key进行解密
	 * @param content 需要AES/CBC/PKCS5Padding解密内容
	 * @param myAesKey 解密秘钥 AES加密秘钥为约定16位，小于16位会报错
	 * @return 返回进行base64解码并进行AES/CBC/PKCS5Padding解密结果字符串
	 * @throws Exception 本方法可能会产生异常,需要上层进行异常捕捉
	 */
	public static String aesCBCPKCS5Decode(String content,String myAesKey)throws Exception{
		Key key = new SecretKeySpec(myAesKey.getBytes(charset), "AES");// 格式化key
		Cipher cipher = Cipher.getInstance(aesCBCPKCS5Algorithm); // 确定算法
		cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(myAesKey.getBytes(charset)));    // 确定密钥
		byte[] bytesContent;
		bytesContent = base64Decode(content);
		byte[] resultByte;  // 解密
		resultByte = cipher.doFinal(bytesContent);
		return new String(resultByte, charset);
	}


	public static String aesGCMNoPaddingDecode(String base64Content, String encryptPass)
			throws Exception {
		String KEY_ALGORITHM="AES";
		byte[] content = base64Decode(base64Content);
		if (content.length < 12 + 16){
			throw new IllegalArgumentException();
		}

		GCMParameterSpec params = new GCMParameterSpec(128, content, 0, 12);
		Cipher cipher = Cipher.getInstance(aesGCMNoPaddingAlgorithm);
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		// 初始化密钥生成器，AES要求密钥长度为128位、192位、256位
		SecureRandom secureRandomKey = SecureRandom.getInstance("SHA1PRNG");
		secureRandomKey.setSeed(encryptPass.getBytes());
		kg.init(128, secureRandomKey);
		SecretKey secretKey = kg.generateKey();
		SecretKeySpec mySecreKey=new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥

		cipher.init(Cipher.DECRYPT_MODE, mySecreKey, params);
		byte[] decryptData = cipher.doFinal(content, 12, content.length - 12);
		return new String(decryptData,charset);
	}

	public static String aesGCMNoPaddingEncode(String content, String encryptPass)
			throws Exception {
		String KEY_ALGORITHM="AES";
		byte[] iv = new byte[12];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(iv);
		byte[] contentBytes = content.getBytes(charset);
		Cipher cipher = Cipher.getInstance(aesGCMNoPaddingAlgorithm);
		GCMParameterSpec params = new GCMParameterSpec(128, iv);

		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		// 初始化密钥生成器，AES要求密钥长度为128位、192位、256位
		SecureRandom secureRandomKey = SecureRandom.getInstance("SHA1PRNG");
		secureRandomKey.setSeed(encryptPass.getBytes());
		kg.init(128, secureRandomKey);
		SecretKey secretKey = kg.generateKey();

		SecretKeySpec mySecreKey=new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥

		cipher.init(Cipher.ENCRYPT_MODE, mySecreKey,params);
		byte[] encryptData = cipher.doFinal(contentBytes);
		assert encryptData.length == contentBytes.length + 16;
		byte[] message = new byte[12 + contentBytes.length + 16];
		System.arraycopy(iv, 0, message, 0, 12);
		System.arraycopy(encryptData, 0, message, 12, encryptData.length);
		return base64Encode(message);
	}
	
	public static String RSAEncode(String publicKey,String base64Content) throws Exception {
        // base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        // RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.encodeBase64String(cipher.doFinal(base64Content.getBytes("UTF-8")));
		
	}
	
    public static String RSADecode(String privateKey,String encodeContent) throws Exception {
        // 64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(encodeContent.getBytes("UTF-8"));
        // base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        // RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }

}
