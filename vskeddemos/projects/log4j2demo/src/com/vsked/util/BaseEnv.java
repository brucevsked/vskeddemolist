package com.vsked.util;

import java.util.Enumeration;
import java.util.Properties;

public class BaseEnv {

	public static void main(String[] args) {
		System.out.println("-------------------------");   
		Properties p = System.getProperties();   
		for (Enumeration e = p.propertyNames(); e.hasMoreElements();) {   
		    String key = (String) e.nextElement();   
		    System.out.println(key + ":" + p.getProperty(key));   
		}   
		System.out.println("-------------------------");  

	}

}
