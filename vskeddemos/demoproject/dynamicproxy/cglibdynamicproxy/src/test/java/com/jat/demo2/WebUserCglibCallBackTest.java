package com.jat.demo2;

import com.jat.demo1.WebUser;
import com.jat.demo1.MyInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class WebUserCglibCallBackTest {

    private static final Logger log = LoggerFactory.getLogger(WebUserCglibCallBackTest.class);

    @Test
    public void createUserCallBack(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(WebUser.class);

        CallbackFilter callbackFilter = new WebUserCallBackFilter();

        /**
         * (1)callback1：方法拦截器
         * (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
         * (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
         */
        Callback noopCb= NoOp.INSTANCE;
        Callback callback1=new MyInterceptor();
        Callback fixedValue=new WebUserResultFixed();
        Callback[] cbarray=new Callback[]{callback1,fixedValue,noopCb};//注意这一句,这一句数组下标很重要！配合过滤器用
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);

        WebUser targetObject2=(WebUser)enhancer.create();

        log.info("当前类是:{}",targetObject2);
        log.info("第1个方法是:{}",targetObject2.checkUserName("mynameisgood"));
        log.info("第2个方法是:{}",targetObject2.checkUserBirth("2021-06-06"));
        targetObject2.checkUserPassword("123456");
    }
}
