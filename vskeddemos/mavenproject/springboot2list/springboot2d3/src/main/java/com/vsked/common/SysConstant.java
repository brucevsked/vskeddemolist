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

    public static final String REDIS_PERM = "perm:";
    /**
     * app登录token前缀
     */
    public static final String REDIS_TOKEN = "token:";
    /**
     * 代理在线状态uid,yyyy-MM-dd
     */
    public static final String REDIS_agentOnlineMap = "agentonline:";
    /**
     * 网页管理端token前缀
     */
    public static final String REDIS_TOKEN_WEB = "webtoken:";
    /**
     * 游客用户观影次数前缀
     */
    public static final String REDIS_guestviewcount = "appguestviewcount:";
    /**
     * 普通用户观影次数前缀
     */
    public static final String REDIS_userviewcount = "appuserviewcount:";
    /**
     * 验证码前缀
     */
    public static final String REDIS_verifycode = "verifycode:";
    
    /**
     * app用户在线用户数
     */
    public static final String REDIS_OnlineAppUserCount = "onlineappusercount:";
    /**
     * app用户在线列表
     */
    public static final String REDIS_OnlineAppUserMap = "onlineappusermap:";
    /**
     * 普通用户角色id
     */
    public static final int commonUserRoleId=102;
    /**
     * vip角色id
     */
    public static final int VipRoleId=104;
    /**
     * app超级管理员用户id
     */
    public static final int appAdminUid=0;
    /**
     * 当前服务器域名或ip
     */
    public static final String curServerDomain="http://42.51.201.144/";
    /**
     * 每次消费观影次数
     */
    public static final int costViewVideoCount=1;

    /**
     * appModuleT表中tbparam多个参数分隔符
     */
    public static final String moduleTbparamSeg1="&";
    /**
     * appModuleT表中tbparam单个参数分隔符
     */
    public static final String moduleTbparamSeg2="=";
    /**
     * 代理掉线时间
     */
    public static final int agentExpireMinutes=11;

}
