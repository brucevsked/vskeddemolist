package com.vsked.util;

public class FileUtil {
	
	public static String getBasePath(){
		return FileUtil.class.getResource("/").getPath().substring(1);
	}
	
    public static void main(String[] args) {
		System.out.println(getBasePath());
	}
}
