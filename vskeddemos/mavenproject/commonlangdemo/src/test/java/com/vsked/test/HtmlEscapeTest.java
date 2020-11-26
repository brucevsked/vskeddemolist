package com.vsked.test;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlEscapeTest {

	public static void main(String[] args) {
		String s1="";
		s1+="<html>";
		s1+="<head>";
		s1+="</head>";
		s1+="<body>";
		s1+="hello this is myc1";
		s1+="<hr>";
		s1+="<font size=10>s1</font>";
		s1+="<script>function t1(){ console.log(1) }</script>";
		s1+="</body>";
		s1+="</html>";
		
		String result=StringEscapeUtils.escapeHtml4(s1);
		//html
		System.out.println(result);
		
		String revResult=StringEscapeUtils.unescapeHtml4(result);
		System.out.println(revResult);

	}

}
