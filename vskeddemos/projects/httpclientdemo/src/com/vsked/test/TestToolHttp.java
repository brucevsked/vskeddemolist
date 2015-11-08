package com.vsked.test;

import com.vsked.util.ToolHttp;

public class TestToolHttp {

	public static void main(String[] args) {
		String getPrameter="";
		getPrameter+="?";
		getPrameter+="userName=admin";
		getPrameter+="&password=admin";
		//System.out.println(ToolHttp.get(false, "http://localhost:8080/hyfd/LoginController/loginCheck.html"+getPrameter));
		
		String postParameter="";
		postParameter+="userName=admin";
		postParameter+="&password=admin";
		System.out.println(ToolHttp.post(false, "http://localhost:8080/hyfd/LoginController/loginCheck.html", postParameter, "application/x-www-form-urlencoded"));
		
		
	}

}
