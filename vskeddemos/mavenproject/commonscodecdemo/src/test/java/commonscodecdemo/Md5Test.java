package commonscodecdemo;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * md5不可逆加密
 * @author brucevsked
 *
 */
public class Md5Test {
	
	private static final Logger log = LoggerFactory.getLogger(Md5Test.class);
	
	@Test
	public void md5Test(){
		String myPass="000000";
		String s=DigestUtils.md5Hex(myPass.getBytes());
		log.debug(s);
	}


}
