package commonscodecdemo;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sha1不可逆加密 相对md5更安全
 * @author brucevsked
 *
 */
public class Sha1Test {
	
	private static final Logger log = LoggerFactory.getLogger(Sha1Test.class);
	
	@Test
	public void sha1Encode(){
		String s="aaa";
		String r=DigestUtils.sha1Hex(s.getBytes());
		log.debug(r);
		
	}
	
}
