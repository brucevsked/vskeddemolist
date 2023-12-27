package com.jat.demo2;

import net.sf.cglib.proxy.CallbackFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class WebUserCallBackFilter implements CallbackFilter {

    private static final Logger log = LoggerFactory.getLogger(WebUserCallBackFilter.class);

    /**
     * 其中return值为被代理类的各个方法在回调数组Callback[]中的位置索引,
     * 参考WebUserCglibCallBackTest类中Callback[] cbarray=new Callback[]{callback1,fixedValue,noopCb};
     * 这里要表达的是:这个方法要使用回调数组中第几个回调方法进行处理。
     * @param method
     * @return
     */
    @Override
    public int accept(Method method) {
        log.info("当前方法名是:{}",method.getName());

        if(method.getName().equals("checkUserName")){
            log.info("filter checkUserName ==0");
            return 0;
        }
        if(method.getName().equals("checkUserBirth")){
            log.info("filter checkUserBirth ==1");
            return 1;
        }
        if(method.getName().equals("checkUserPassword")){
            log.info("filter checkUserPassword ==2");
            return 2;
        }
        return 0;
    }
}
