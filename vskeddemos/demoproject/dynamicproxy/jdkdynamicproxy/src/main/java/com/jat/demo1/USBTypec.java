package com.jat.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USBTypec implements USB{

    private static final Logger log = LoggerFactory.getLogger(USBTypec.class);

    @Override
    public void sendData() {
        log.info("this is USBType c send data!");
    }
}
