package com.vsked.text;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

public class PythonUtf8 {
	
	//单个字符的正则表达式
    static String singlePattern = "[0-9|a-f|A-F]";
    // 4个字符的正则表达式
    static String pattern = singlePattern + singlePattern +singlePattern + singlePattern;

	public static void main(String[] args) {
		try {
		//转换utf-8编码1
		String s="\\xe4\\xba\\xba\\xe5\\x91\\x98\\xe5\\xae\\x9e\\xe6\\x97\\xb6\\xe6\\x95\\xb0\\xe6\\x8d\\xae\\xe5\\xa4\\x84\\xe7\\x90\\x86";
		String r=urlToUtf8(s);
		System.out.println("|"+r+"|");
		
		//转换utf-8编码2
		String us="\\u7279\\u79cd\\u4eba\\u5458";
		String rus=unicodeToCn(us);
		System.out.println("|"+rus+"|");
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 把 \\u 开头的单字转成汉字，如 \\u6B65 ->　步
	 * @param str
	 * @return
	 */
	static String ustartToCn(final String str) {
		StringBuilder sb = new StringBuilder().append("0x")
				.append(str.substring(2, 6));
		Integer codeInteger = Integer.decode(sb.toString());
		int code = codeInteger.intValue();
		char c = (char)code;
		return String.valueOf(c);
	}
	
	/**
	 * 字符串是否以Unicode字符开头。约定Unicode字符以 \\u开头。
	 * @param str 字符串
	 * @return true表示以Unicode字符开头.
	 */
	static boolean isStartWithUnicode(final String str) {
		if (null == str || str.length() == 0) {
			return false;
		}
		if (!str.startsWith("\\u")) {
			return false;
		}
		// \u6B65
		if (str.length() < 6) {
			return false;
		}
		String content = str.substring(2, 6);
		
		boolean isMatch = Pattern.matches(pattern, content);
		return isMatch;
	}

	
	public static String unicodeToCn(final String str) {
		// 用于构建新的字符串
		StringBuilder sb = new StringBuilder();
		//从左向右扫描字符串。tmpStr是还没有被扫描的剩余字符串。
		// 下面有两个判断分支：
		// 1. 如果剩余字符串是Unicode字符开头，就把Unicode转换成汉字，加到StringBuilder中。然后跳过这个Unicode字符。
		// 2.反之， 如果剩余字符串不是Unicode字符开头，把普通字符加入StringBuilder，向右跳过1.
		int length = str.length();
		for (int i = 0; i < length;) {
			String tmpStr = str.substring(i);
			if (isStartWithUnicode(tmpStr)) { // 分支1
				sb.append(ustartToCn(tmpStr));
				i += 6;
			} else { // 分支2
				sb.append(str.substring(i, i + 1));
				i++;
			}
		}
		return sb.toString();
	}
	
	public static String urlToUtf8(String s) throws UnsupportedEncodingException {
		s=s.replaceAll("\\\\x", "%");
		String r=URLDecoder.decode(s, "UTF-8");
		return r;
	}


}
