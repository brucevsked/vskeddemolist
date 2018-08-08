package com.vsked.text;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class NumberAddSpace {
	static String excelColumn="	";

	public static void main(String[] args) {
		try{
		String pathname="e:/mcc.txt";
		String pathnamen="e:/mccn.txt";
		List<String> dataListNew=new LinkedList<String>();
		List<String> dataListOld=FileUtils.readLines(new File(pathname),"utf-8");
		
		String tmpNumber="";
		
		for(String s:dataListOld){
			tmpNumber="";
			tmpNumber=getNumber(s);
			s=s.replace(tmpNumber, "");
			s=s+excelColumn+tmpNumber;
			dataListNew.add(s);
		}
		
		FileUtils.writeLines(new File(pathnamen), dataListNew, true);
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static String getNumber(String s){
		Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(s);
        String all = matcher.replaceAll("");
        return all;
	}

}
