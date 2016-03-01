package com.vsked.test;

import java.awt.event.ActionEvent;

public class Browser_jAddressTextField_actionAdapter implements java.awt.event.ActionListener {
    Browser adaptee;

    Browser_jAddressTextField_actionAdapter(Browser adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jAddressTextField_actionPerformed(e);
    }
}
