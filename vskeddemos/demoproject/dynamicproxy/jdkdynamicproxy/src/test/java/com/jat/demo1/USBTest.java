package com.jat.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class USBTest {

    private static final Logger log = LoggerFactory.getLogger(USBTest.class);

    @Test
    public void myUsbTest(){
        USBTypec usbTypec=new USBTypec();
        USB proxyObj = (USB) Proxy.newProxyInstance(USB.class.getClassLoader(),
                new Class[]{USB.class},
                new MyInvocationHandler(usbTypec));
        proxyObj.sendData();
    }

}
