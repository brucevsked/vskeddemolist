package com.jat.demo2;

import net.sf.cglib.proxy.FixedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUserResultFixed implements FixedValue {

    private static final Logger log = LoggerFactory.getLogger(WebUserResultFixed.class);

    /**
     * 该类实现FixedValue接口，同时锁定回调值为999
     * (整型，CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型)。
     */
    @Override
    public Object loadObject() throws Exception {
        log.info("锁定结果");
        Object obj = 999;
        return obj;
    }
}
