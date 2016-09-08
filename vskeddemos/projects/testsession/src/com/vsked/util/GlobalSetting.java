package com.vsked.util;

import java.util.HashMap;
import java.util.Map;


public class GlobalSetting {
	
	public static Map<String, Double> osBalance = new HashMap<String, Double>();
	
	public static synchronized boolean getOsBalance(Double agentvalue, String agentname,Double terminalvalue, String terminalname) {
		if(!StringUtils.isEmpty(agentname) && !StringUtils.isEmpty(terminalname)){
			if (agentvalue > 0 ) {
				osBalance.put(agentname, osBalance.get(agentname) + agentvalue);
				System.out.println("a1 osBalance:[" + GlobalSetting.osBalance + "]");
				return true;
			} else {
				if (osBalance.get(agentname) + agentvalue < 0 || osBalance.get(terminalname)+terminalvalue < 0) {
					System.out.println("a2 osBalance:[" + GlobalSetting.osBalance + "]");
					return false;
				} else {
					osBalance.put(agentname, osBalance.get(agentname) + agentvalue);
					osBalance.put(terminalname, osBalance.get(terminalname) + terminalvalue);
					System.out.println("a3 osBalance:[" + GlobalSetting.osBalance + "]");
					return true;
				}
			}
		}else if(!StringUtils.isEmpty(agentname)){
			if (agentvalue > 0 ) {
				osBalance.put(agentname, osBalance.get(agentname) + agentvalue);
				System.out.println("a4 osBalance:[" + GlobalSetting.osBalance + "]");
				return true;
			} else {
				if (osBalance.get(agentname) + agentvalue < 0 ) {
					System.out.println("a5 osBalance:[" + GlobalSetting.osBalance + "]");
					return false;
				} else {
					osBalance.put(agentname, osBalance.get(agentname) + agentvalue);
					System.out.println("a6 osBalance:[" + GlobalSetting.osBalance + "]");
					return true;
				}
			}
		}else if(!StringUtils.isEmpty(terminalname)){
			if (terminalvalue > 0 ) {
				osBalance.put(terminalname, osBalance.get(terminalname) + terminalvalue);
				System.out.println("a7 osBalance:[" + GlobalSetting.osBalance + "]");
				return true;
			} else {
				if (osBalance.get(terminalname) + terminalvalue < 0 ) {
					System.out.println("a8 osBalance:[" + GlobalSetting.osBalance + "]");
					return false;
				} else {
					osBalance.put(terminalname, osBalance.get(terminalname) + terminalvalue);
					System.out.println("a9 osBalance:[" + GlobalSetting.osBalance + "]");
					return true;
				}
			}
		}else{
			return false;
		}
		
	}

}
