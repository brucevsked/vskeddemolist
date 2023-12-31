package com.jat.user.event;

import com.jat.user.User;
import org.springframework.context.ApplicationEvent;

/**
 * 第一步声明一个事件
 */
public class UserStoreEvent extends ApplicationEvent {
    private User user;
    public UserStoreEvent(Object source,User user) {
        super(source);
        this.user=user;
    }

    public User getUser() {
        return user;
    }
}
