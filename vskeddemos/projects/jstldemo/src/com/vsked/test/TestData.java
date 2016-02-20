package com.vsked.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class TestData {
	
    public static void listMapData(HttpServletRequest req){
    	List<Map<String, String>> al=new LinkedList<Map<String,String>>();
    	
    	for(int i=0;i<10;i++){
    	Map<String, String> m=new HashMap<String, String>();
    	m.put("userName", i+"user");
    	m.put("userPass", "pass"+i);
    	al.add(m);
    	}
    	req.setAttribute("userDataList", al);
    }
	public static void main(String[] args) {

	}

}
