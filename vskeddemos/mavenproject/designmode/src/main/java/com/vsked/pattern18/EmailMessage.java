package com.vsked.pattern18;

import java.util.ArrayList;
import java.util.List;



public class EmailMessage implements Message{

    private List<Observer> observers=new ArrayList<Observer>();

    public void Add(Observer observer) {
        observers.add(observer);

    }

    public void delete(Observer observer) {
        observers.remove(observer);
    }

    public void notice() {
        for (Observer observer : observers) {
            observer.notice();
        }
    }

}
