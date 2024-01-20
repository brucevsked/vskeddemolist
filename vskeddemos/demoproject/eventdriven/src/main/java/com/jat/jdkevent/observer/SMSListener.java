package com.jat.jdkevent.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SMSListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("--------------发送短信"+evt.getPropertyName()+"|"+evt.getOldValue()+"|"+evt.getNewValue());
    }

}
