package com.jat.jdkevent.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CouponListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("--------------优惠券搞定"+evt.getPropertyName()+"|"+evt.getOldValue()+"|"+evt.getNewValue());
    }
}
