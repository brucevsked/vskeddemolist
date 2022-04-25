package commonscodecdemo;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.nio.charset.StandardCharsets;

public class Base64Test {

    private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void encode(){
        String source="123456789";
        String result= Base64.encodeBase64String(source.getBytes(StandardCharsets.UTF_8));
        log.info("{}",result);
    }

    @Test
    public void decode(){
        String source="MTIzNDU2Nzg5";
        byte[] resultByte= Base64.decodeBase64(source);
        String result=new String(resultByte);
        log.info("{}",result);
    }
}
