package com.vsked.text;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlDecode {

	public static void main(String[] args) {
		//转换utf-8编码1
		String s="\\x80\\x00\\x00\\x00\\x00\\x00\\x00\\x01";
		String r;
		try {
			r = urlToUtf8(s);
			System.out.println("|"+r+"|");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String urlToUtf8(String s) throws UnsupportedEncodingException {
		s=s.replaceAll("\\\\x", "%");
		String r=URLDecoder.decode(s, "UTF-8");
		return r;
	}

}
