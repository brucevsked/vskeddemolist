package com.vsked.test;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class TestStoreUrl {

	public static void main(String[] args) throws Exception {
		Map tm=new HashMap();
		tm.put("1", "11");
		System.out.println(tm.size());
		getSystemInfo();
	}
	

	public static void getSystemInfo(){
		Properties systemProperties = System.getProperties();
	      Enumeration en = systemProperties.propertyNames();
	      while (en.hasMoreElements())
	      {
	         String key = (String)en.nextElement();
	         System.out.println(key + "=" + systemProperties.getProperty(key));
	      }
	}
	


}
