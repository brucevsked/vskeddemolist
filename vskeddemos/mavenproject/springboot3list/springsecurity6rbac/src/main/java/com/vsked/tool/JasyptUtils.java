package com.vsked.tool;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtils {

	/**
     * Jasypt生成加密结果
     *
     * @param secretKey 密钥  jasypt.encryptor.password
     * @param content    待加密值
     * @return 加密后结果
     */
    public static String encrypt(String secretKey, String content) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(secretKey));
        return encryptOr.encrypt(content);
    }
    
    /**
     * 解密
     *
     * @param secretKey 密钥  jasypt.encryptor.password
     * @param content    待解密密文
     * @return 解密后结果
     */
    public static String decypt(String secretKey, String content) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(secretKey));
        return encryptOr.decrypt(content);
    }

    /**
     * @param secretKey 密钥  jasypt.encryptor.password
     * @return 加密配置
     */
    public static SimpleStringPBEConfig cryptOr(String secretKey) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(secretKey);
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }
    
}
