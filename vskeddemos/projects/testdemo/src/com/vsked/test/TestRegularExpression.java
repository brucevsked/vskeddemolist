package com.vsked.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vsked.util.FileProcess;

public class TestRegularExpression {
	public static String xmlHeadStart="<?xml";
	public static String nameSpaceStart="<[a-zA-Z]++:[a-zA-Z]++";
	public static String tagName="(<\\w++)";
	public static String tagStart="<\\w++\\s++";
	public static String attr="\\s\\w++=[\"|']\\w++[\"|']";

	public static void main(String[] args) throws Exception {
		String regularExpressionStr=tagName;
		String fc=FileProcess.readFile(new File("c:/t.xml"));
		for(String s:getElementsByTagName(fc,"Data"))
			System.out.println(s);
	}
	public static Set<String> getTagList(String c){
		Set tagSet=new HashSet<String>();
		Matcher m = Pattern.compile(tagName).matcher(c);
		while(m.find())
			tagSet.add(m.group().substring(1));
		return tagSet;
	}
	
	public static List<String> getAttributeList(String tag){
		List attrList=new ArrayList<String>();
		Matcher m = Pattern.compile(tagName).matcher(tag);
		while(m.find())
			attrList.add(m.group().substring(1));
		return attrList;
	}
	public static List<String> getElementsTagStartByTagName(String parentElementString,String tagName) {
		ArrayList<String> al = new ArrayList<String>();
		Matcher m = Pattern.compile("<"+tagName+"\\s+[^>]+>").matcher(parentElementString);
		while (m.find())
			al.add(m.group());
		return al;
    }
	
	public static List<String> getElementsByTagName(String parentElementString,String tagName) {
		ArrayList<String> al = new ArrayList<String>();
		Matcher m = Pattern.compile("<\\s+"+tagName+"\\w*((>.*?</"+tagName+">)|(/>))").matcher(parentElementString);
		while (m.find())
			al.add(m.group());
		return al;
    }
	public static String getElementText(String elementString) {
		  Matcher m = Pattern.compile(">([^<>]*)<").matcher(elementString);
		  return m.find()?m.group(1):"";
  }
}
