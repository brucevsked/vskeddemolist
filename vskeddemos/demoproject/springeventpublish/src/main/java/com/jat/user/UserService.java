package com.jat.user;

import com.jat.user.event.UserStoreEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void save(User user){
        //第三步推送事件，推送的事件会被事件监听器监听到
        UserStoreEvent userStoreEvent=new UserStoreEvent(this,user);
        applicationEventPublisher.publishEvent(userStoreEvent);
    }
}
