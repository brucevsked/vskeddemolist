package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jStopButton_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jStopButton_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jStopButton_actionPerformed(e);
    }
}
