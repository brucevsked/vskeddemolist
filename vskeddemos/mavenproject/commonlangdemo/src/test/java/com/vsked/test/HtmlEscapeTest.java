package com.vsked.test;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class HtmlEscapeTest {

	private static final Logger log = LoggerFactory.getLogger(HtmlEscapeTest.class);

	@Test
	public void oldHtmlEscape(){
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
		//html 已经过时 需要更新为common-text包中org.apache.commons.text.StringEscapeUtils
		log.debug(result);

		String revResult=StringEscapeUtils.unescapeHtml4(result);
		log.debug(revResult);
	}

	@Test
	public void htmlEscape(){
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

		//新版本用法
		String result=org.apache.commons.text.StringEscapeUtils.escapeHtml4(s1);
		log.debug(result);

		String revResult=org.apache.commons.text.StringEscapeUtils.unescapeHtml4(result);
		log.debug(revResult);
	}



}
