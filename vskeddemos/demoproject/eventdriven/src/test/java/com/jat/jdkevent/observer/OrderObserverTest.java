package com.jat.jdkevent.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class OrderObserverTest {
    private static final Logger log = LoggerFactory.getLogger(OrderObserverTest.class);

    @Test
    public void test1(){
        OrderObserver ob=new OrderObserver("订单1");
        ob.addPropertyChangeListener(new CouponListener());
        ob.addPropertyChangeListener(new PointsListener());
        ob.addPropertyChangeListener(new SMSListener());

        ob.setOrderState(0);


    }
}
