package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jForwardButton_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jForwardButton_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jForwardButton_actionPerformed(e);
    }
}
