package com.jat.demo3;

import net.sf.cglib.proxy.Dispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteClassDispatcher implements Dispatcher {

    private static final Logger log = LoggerFactory.getLogger(ConcreteClassDispatcher.class);

    @Override
    public Object loadObject() throws Exception {
        log.info("每次都加载呀，每调一次方法都会加载呀");
        EveryTime propertyBean = new EveryTime();
        propertyBean.setSleepName("名字");
        propertyBean.setArea("地区");
        propertyBean.setWidth(1000);
        propertyBean.setHeight(2000);

        return propertyBean;
    }

}
