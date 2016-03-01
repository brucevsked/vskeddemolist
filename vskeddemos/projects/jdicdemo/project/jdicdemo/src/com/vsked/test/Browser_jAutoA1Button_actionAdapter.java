package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jAutoA1Button_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jAutoA1Button_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jAutoA1Button_actionPerformed(e);
    }
}
