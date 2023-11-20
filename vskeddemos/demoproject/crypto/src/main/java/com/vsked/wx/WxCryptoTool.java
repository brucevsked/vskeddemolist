package com.vsked.wx;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


public class WxCryptoTool {
	
	static Cipher cipher=null;
	
	public static String decryptData(String paternerKeyMd5,byte[] decryptDataBase64Decode) throws Exception {
		
	    SecretKeySpec keySpec = new SecretKeySpec(paternerKeyMd5.getBytes(), "AES");
	    Security.addProvider(new BouncyCastleProvider());
	    
	    if(cipher==null) {
	    	 cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
	         cipher.init(Cipher.DECRYPT_MODE, keySpec);
	    }
	    return new String(cipher.doFinal(decryptDataBase64Decode), "UTF-8");
	}


}
