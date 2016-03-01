package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jGoButton_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jGoButton_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jGoButton_actionPerformed(e);
    }
}
