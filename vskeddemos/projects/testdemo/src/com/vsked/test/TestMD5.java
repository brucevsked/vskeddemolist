package com.vsked.test;

import com.vsked.util.Base64;
import com.vsked.util.Md5;

public class TestMD5 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(Md5.getEncode("1234"));
		System.out.println(Base64.encode("1234".getBytes()));
	}

}
