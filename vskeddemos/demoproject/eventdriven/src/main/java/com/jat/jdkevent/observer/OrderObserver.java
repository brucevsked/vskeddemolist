package com.jat.jdkevent.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderObserver {

    private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    private String orderName;
    private int orderState;

    public OrderObserver(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderState(int orderState){
        this.orderState = orderState;
        //发布监听事件
        firePropertyChange("state", orderName, orderState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        listeners.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String prop, Object oldValue, Object newValue) {
        listeners.firePropertyChange(prop, oldValue, newValue);
    }


}
