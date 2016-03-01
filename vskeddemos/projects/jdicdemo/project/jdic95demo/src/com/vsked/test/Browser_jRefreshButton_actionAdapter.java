package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jRefreshButton_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jRefreshButton_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jRefreshButton_actionPerformed(e);
    }
}
