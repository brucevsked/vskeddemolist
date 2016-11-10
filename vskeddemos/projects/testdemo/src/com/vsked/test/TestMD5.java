package com.vsked.test;


import org.apache.commons.codec.digest.DigestUtils;

import com.vsked.util.Base64;
import com.vsked.util.Md5;

public class TestMD5 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testMd5A1();
		testMd5A2();
	}
	
	public static void testMd5A1(){
		try {
			System.out.println(Md5.getEncode("000000"));
			System.out.println(Base64.encode("000000".getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testMd5A2(){
		String s="000000";
		String result=DigestUtils.md5Hex(s.getBytes());
		System.out.println(result);
	}

}
