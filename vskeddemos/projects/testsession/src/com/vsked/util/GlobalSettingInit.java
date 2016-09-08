package com.vsked.util;



public class GlobalSettingInit {
	
	public static boolean isInit=false;
	
	public static void init(){
		
		GlobalSetting.osBalance.put("agent_a1", new Double("1000.0"));
		GlobalSetting.osBalance.put("agent_a2", new Double("2000.0"));
		GlobalSetting.osBalance.put("agent_a3", new Double("3000.0"));
		
		GlobalSetting.osBalance.put("terminal_t1", new Double("1100.0"));
		GlobalSetting.osBalance.put("terminal_t2", new Double("2100.0"));
		GlobalSetting.osBalance.put("terminal_t3", new Double("3100.0"));
		
		System.out.println("启动时，osBalance:[" + GlobalSetting.osBalance + "]");
		isInit=true;
	}

}
