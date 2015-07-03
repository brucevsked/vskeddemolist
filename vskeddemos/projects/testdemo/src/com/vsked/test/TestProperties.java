package com.vsked.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		 Properties properties = System.getProperties();
		// properties.load(new FileInputStream(new File("c:/t.properties")));
		
		 Enumeration<?> en = properties.propertyNames();
         while (en.hasMoreElements()) {
          String key = (String) en.nextElement();
          String Property = properties.getProperty (key);
          System.out.println(key+"||"+Property);
         }
		 
	}

}
