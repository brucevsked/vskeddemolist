package com.vsked.auth.domain.entity;

import com.vsked.auth.domain.aggregate.Session;
import com.vsked.common.ProjectGlobalSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 会话管理器
 */
@Component
public class SessionManagement {

    private static final Logger log = LoggerFactory.getLogger(SessionManagement.class);


    @Scheduled(cron = ProjectGlobalSetting.sessionCheckIntervalCron)
    public void sessionExpireCheck() {
        log.debug("check session start");
    }

    public static void createSession(Session session) {
        //创建会话
        if(!ProjectGlobalSetting.onlineUserMap.containsKey(session.getSessionId())){
            ProjectGlobalSetting.onlineUserMap.put(session.getSessionId(),session);
            log.debug(ProjectGlobalSetting.onlineUserMap+"");
        }else{
            log.debug("you has login please check account");
        }

    }

    public void destorySession(Session session) {
        //销毁会话
        if(ProjectGlobalSetting.onlineUserMap.containsKey(session.getSessionId())){
            ProjectGlobalSetting.onlineUserMap.remove(session.getSessionId());
        }
    }

    public void checkSession() {
        //检查会话
    }

}
