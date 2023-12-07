package com.vsked.common;

import com.vsked.auth.domain.aggregate.Session;
import com.vsked.auth.domain.valueobject.SessionId;

import java.util.HashMap;
import java.util.Map;

public class ProjectGlobalSetting {

    /**
     * 默认会话过期时间5小时
     */
    public static final Long sessionExpireTime=new Long(1000*60*60*24);

    /**
     * 每隔2小时检查一次
     */
    //public static final String sessionCheckIntervalCron="0 0 0/2 * * ?";
    public static final String sessionCheckIntervalCron="0 */2 * * * ?"; //2分钟执行一次

    /**
     * 在线用户会话列表
     */
    public static Map<SessionId, Session> onlineUserMap=new HashMap<SessionId, Session>();

    /**
     * jwt加密密钥
     */
    public static String jwtKey="tianxiayingxiongchuwobeijiushibufu110";

    /**
     * jwt的token过期时间 默认1天（秒*分钟*小时*1000）
     */
    public static Long jwtExpireTime=new Long(60 * 60 * 24*1000);



}
