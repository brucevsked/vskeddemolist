package com.vsked.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CryptoToolTest {

    private static final Logger log = LoggerFactory.getLogger(CryptoToolTest.class);

    @Test
    public void md5Encode() {
        String content = "yunze521";
        String md5 = CryptoTool.md5Encode(content);
        log.info("md5: {}", md5);
    }
}
