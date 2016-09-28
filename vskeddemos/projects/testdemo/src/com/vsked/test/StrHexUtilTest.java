package com.vsked.test;

import java.math.BigInteger;

public class StrHexUtil {

	public static void main(String[] args) throws Exception {
		String s1="\\xe5\\xb8\\x90\\xe5\\x8f\\xb7\\xe4\\xbf\\xa1\\xe6\\x81\\xaf\\xe4\\xb8\\x8d\\xe5\\xad\\x98\\xe5\\x9c\\xa8\\xe6\\x88\\x96\\xe7\\x8a\\xb6\\xe6\\x80\\x81\\xe4\\xb8\\x8d\\xe6\\xad\\xa3\\xe5\\xb8\\xb8";
		System.out.println(hex2Str(s1));

	}
	
	public static String str2Hex(String str) throws Exception {
		String hexRaw = String.format("%x", new BigInteger(1, str.getBytes("UTF-8")));
		char[] hexRawArr = hexRaw.toCharArray();
		StringBuilder hexFmtStr = new StringBuilder();
		final String SEP = "\\x";
		for (int i = 0; i < hexRawArr.length; i++) {
			hexFmtStr.append(SEP).append(hexRawArr[i]).append(hexRawArr[++i]);
		}
		return hexFmtStr.toString();
	}

	public static String hex2Str(String str) throws Exception {
		String strArr[] = str.split("\\\\"); // 分割拿到形如 xE9 的16进制数据
		byte[] byteArr = new byte[strArr.length - 1];
		for (int i = 1; i < strArr.length; i++) {
			Integer hexInt = Integer.decode("0" + strArr[i]);
			byteArr[i - 1] = hexInt.byteValue();
		}

		return new String(byteArr, "UTF-8");
	}

}
