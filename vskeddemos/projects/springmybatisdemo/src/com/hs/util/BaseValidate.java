package com.hs.util;

import java.util.regex.Pattern;

public class BaseValidate {
	
	public static boolean isNumber(String s){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(s).matches();    
	}

}
