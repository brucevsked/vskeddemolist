package com.vsked.common;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class GlobalSession {
	
	public static Map<String, Session> sessionMap=new HashMap<String, Session>();
	
	public boolean isExistSession(String sname){
		return sessionMap.containsKey(sname);
	}
	
	public void addSession(String sname,Session s){
		sessionMap.put(sname, s);
	}
	
	public void removeSession(String sname){
		sessionMap.remove(sname);
	}

}
