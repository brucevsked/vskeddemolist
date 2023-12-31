package com.jat.user.eventListener;

import com.jat.user.event.UserStoreEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserStoreFileListener {

    private static final Logger log = LoggerFactory.getLogger(UserStoreFileListener.class);

    @EventListener
    public void processEvent(UserStoreEvent userStoreEvent){
        log.info("----准备将数据存储到----文件，这可是文件");
        log.info("file store:{}",userStoreEvent.getUser());
    }
}
