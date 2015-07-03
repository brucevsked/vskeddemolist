package com.vsked.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.vsked.model.Player;

public class HessianClient {

	public static void main(String[] args) throws Exception {
		String u = "http://localhost:8080/hessiandemo/GetDataNow";  
		HessianProxyFactory f = new HessianProxyFactory();  
		
		Player p=(Player) f.create(Player.class, u);
		
		System.out.println(p.getPlayerName("vod"));

	}

}
