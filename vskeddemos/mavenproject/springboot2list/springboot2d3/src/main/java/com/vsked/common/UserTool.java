package com.vsked.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserTool {
	
	String emailReaular="\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
	Pattern emailPattern = Pattern.compile(emailReaular);
	
	String mobilePhoneReaular="\\d{9,12}";
	Pattern mobilePhonePattern = Pattern.compile(mobilePhoneReaular);
	
	String userNameReaular="[a-zA-Z0-9_-]{4,16}";
	Pattern userNamePattern = Pattern.compile(userNameReaular);
	
	public boolean isUserName(String str){
		boolean flag=false;
		Matcher m = userNamePattern.matcher(str);
		flag= m.matches();
		return flag;
	}
	
	public boolean isEmail(String str){
		boolean flag=false;
		Matcher m = emailPattern.matcher(str);
		flag= m.matches();
		return flag;
	}
	
	public boolean isMobilePhone(String str){
		boolean flag=false;
		Matcher m = mobilePhonePattern.matcher(str);
		flag= m.matches();
		return flag;
	}

}
