package com.vsked.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5{

    public static String getEncode(String key) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(key.getBytes());
        byte digest[] = messageDigest.digest();
        int j = digest.length;
        char str[] = new char[j * 2];
        int k = 0;
        for(int i = 0; i < j; i++) {
            byte byte0 = digest[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }

        return new String(str);
    }

    static final char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

}