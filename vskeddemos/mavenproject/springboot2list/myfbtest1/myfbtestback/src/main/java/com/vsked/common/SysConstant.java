package com.vsked.common;

public class SysConstant {
    // 初始化页数
    public static final Integer PAGE_NUM = 10;

    public static final String JWT_SECRET = "HeyThis_VskedKey";
    /**
     * 过期时间15天
     */
    public static final Long EXPIRE_TIME = (long) (60 * 60 * 24 * 15);
    /**
     * 过期时间1天
     */
    public static final Long EXPIRE_TIME_1Day = (long) (60 * 60 * 24);
    /**
     * 过期时间5分钟
     */
    public static final Long EXPIRE_TIME_5Minutes = (long) (60 * 5);
    /**
     * 用户权限前缀
     */
    public static final String REDIS_PERM = "perm:";
    /**
     * app登录token前缀
     */
    public static final String REDIS_TOKEN = "token:";
}
