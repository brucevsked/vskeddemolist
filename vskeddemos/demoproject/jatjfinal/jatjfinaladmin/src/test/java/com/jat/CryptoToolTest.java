package com.jat;

import com.jat.util.CryptoTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CryptoToolTest {

    private static final Logger log = LoggerFactory.getLogger(CryptoToolTest.class);

    @Test
    public void md5_32bit_lower(){
        String sourceText="123456";
        String resultText= CryptoTool.md5Encode(sourceText);
        log.info("{}",resultText);
    }

}
