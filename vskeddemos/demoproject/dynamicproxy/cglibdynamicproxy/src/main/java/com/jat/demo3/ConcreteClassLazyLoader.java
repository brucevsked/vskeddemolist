package com.jat.demo3;

import net.sf.cglib.proxy.LazyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteClassLazyLoader implements LazyLoader {

    private static final Logger log = LoggerFactory.getLogger(ConcreteClassLazyLoader.class);

    /**
     * 对需要延迟加载的对象添加代理，在获取该对象属性时先通过代理类回调方法进行对象初始化。
     * 在不需要加载该对象时，只要不去获取该对象内属性，该对象就不会被初始化了（在CGLib的实现中只要去访问该对象内属性的getter方法，
     * 就会自动触发代理类回调）。
     */
    @Override
    public Object loadObject() throws Exception {
        log.info("只会加载一次呀");

        OnlyOne propertyBean = new OnlyOne();
        propertyBean.setKey("mylove");
        propertyBean.setValue("你怎么这么好看");
        return propertyBean;
    }

}
