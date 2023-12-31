package com.jat.user.eventListener;

import com.jat.user.event.UserStoreEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 第二步为事件写一个监听，也就是事件如何处理
 */
@Component
public class UserStoreDBListener {

    private static final Logger log = LoggerFactory.getLogger(UserStoreDBListener.class);

    @EventListener
    public void processEvent(UserStoreEvent userStoreEvent){
        log.info("----准备将数据存储到数据库，数据库啦啦");
        log.info("db store:{}",userStoreEvent.getUser());
    }
}
