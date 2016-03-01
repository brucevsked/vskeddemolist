package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jBackButton_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jBackButton_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jBackButton_actionPerformed(e);
    }
}
