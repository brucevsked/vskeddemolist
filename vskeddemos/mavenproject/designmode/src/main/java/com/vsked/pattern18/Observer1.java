package com.vsked.pattern18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体观察者
 * @author liaowp
 *
 */
public class Observer1 implements Observer{

    private static final Logger log = LoggerFactory.getLogger(Observer1.class);

    @Override
    public void notice() {
        log.info("observer1收到推送");
    }

}
