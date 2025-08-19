package com.vsked.tool;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoTool {

    /**
     * md5加密
     * @param content 需要加密的内容
     * @return string 返回md5加密后字符串
     */
    public static String md5Encode(String content){
        return DigestUtils.md5Hex(content);
    }
}
