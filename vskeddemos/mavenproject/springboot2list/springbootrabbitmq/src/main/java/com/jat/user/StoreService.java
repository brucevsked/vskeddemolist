package com.jat.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private static final Logger log = LoggerFactory.getLogger(StoreService.class);

    /**
     * 更新存储对象状态
     * @param id 存储对象唯一标识
     * @param state 状态0未存储1已经存储
     */
    public void updateStoreState(String id,int state){
        log.info("更新存储对象状态完成:{},{}",id,state);
    }
}
