package com.jat.jdkevent.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PointsListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("--------------积分来了"+evt.getPropertyName()+"|"+evt.getOldValue()+"|"+evt.getNewValue());
    }

}
