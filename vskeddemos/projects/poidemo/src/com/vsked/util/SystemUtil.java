package com.vsked.util;

import java.net.URL;

public class SystemUtil {

	//file:/L:/CompanyFiles/vskedresult/vskeddemos/projects/poidemo/WebRoot/WEB-INF/classes/testw.docx
	public static URL getUrl(String inPath) throws Exception{
		return new URL(ClassLoader.getSystemResource("")+inPath);
	}
	public static String getSystemPath(String inPath) throws Exception{
		return getUrl(inPath).toString().replace(getUrl(inPath).getProtocol()+":/", "");
	}
	public static String getOS() {
		String osName = System.getProperty("os.name");
		if (osName.indexOf("indows") >= 0) return "Windows";
		if (osName.indexOf("SunOS") >= 0) return "Solaris";
		if (osName.indexOf("inux") >= 0) return "Linux";
		else return "Unknown";
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getOS());
		System.out.println(getUrl(""));
		System.out.println(getUrl("testw.docx"));
		System.out.println(getSystemPath(""));
		System.out.println(getSystemPath("testw.docx"));
	}
}
