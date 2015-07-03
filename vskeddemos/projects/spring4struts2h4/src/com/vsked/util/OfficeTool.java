package com.vsked.util;


public class OfficeTool {
	static String wt="w:t";
	static String wp="w:p";
	static String wr="w:r";
	static String wordExt=".docx";
	static String path="c:/t"+wordExt;
	
	static String contentFileName="word/document.xml";

	public static void main(String[] args) {
		String p="c:/005.docx";
		System.out.println(getFileContent(p));		
	}//end main
	public static boolean isExistTag(String t,String tagName){
		return t.indexOf(tagName)!=-1;		
	}
	public static String getContentInLine(String s){
		String ca="";
		while(isExistTag(s, "<"+wt+">")){
			String c=(s.substring(s.indexOf("<"+wt+">")+5, s.indexOf("</"+wt+">")));
			System.out.println(c);
			ca+=c;
			s=s.substring(s.indexOf("</"+wt+">")+6);
		}
		return ca;
	}
	public static String getFileContent(String fpath){
		String fcontent=CompressFile.readFileContentInZip(fpath, contentFileName);
		String ca="";
		while(isExistTag(fcontent, wp+" ")){
		String s=fcontent.substring(fcontent.indexOf("<"+wp+" "), fcontent.indexOf("/"+wp+">")-1);
		ca+=getContentInLine(s)+"\n";
		fcontent=fcontent.substring(fcontent.indexOf("/"+wp+">")+5);
		}
		return ca;
	}
	

}//end class
