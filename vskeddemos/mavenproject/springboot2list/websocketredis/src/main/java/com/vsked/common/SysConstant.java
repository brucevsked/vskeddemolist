package com.vsked.common;

import java.util.HashMap;
import java.util.Map;

import org.yeauty.pojo.Session;

public class SysConstant {
	
	/**
	 * 用来存储本地服务器的websocket会话信息，Map<token,会话>
	 */
	public static Map<String, Session> webSocketSessionMap=new HashMap<String, Session>();
	
	/**
	 * 
	 */
	public static String webSocketChannel="serverC1";

	/**
	 * redis中主题与推送token对应表，用来向前端推送消息用
	 */
	public static String webSocketTopicToken="websockettopictoken:";

}
