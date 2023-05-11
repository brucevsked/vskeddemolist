package com.vsked.pattern10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ProxyPatternTest {
    private static final Logger log = LoggerFactory.getLogger(ProxyPatternTest.class);

    @Test
    public void proxyTest(){
        log.trace("proxyTest");
        Person zhangSan=new ZhangSan();
        zhangSan.buyTicket();//买张三自己的票

        Person lisi=new LiSi();
        zhangSan=new ZhangSan(lisi);
        zhangSan.buyTicket();//张三代李四买票

        Person wangWu=new WangWu();
        zhangSan=new ZhangSan(wangWu);
        zhangSan.buyTicket();//张三代理王五买票

    }
}
