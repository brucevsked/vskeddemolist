package com.vsked.test;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class TestInternetIP {

	public static void main(String[] args) throws Exception {
		List<String> ipList=getIpAddresses();
		for(String s:ipList){
			System.out.println(s);
		}
	}

	public static List<String> getIpAddresses() throws Exception {
		List<String> ipAddressList = new ArrayList<String>();
		InetAddress[] ipAddresses = null;
		ipAddresses = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

		if ((ipAddresses != null) && (ipAddresses.length > 0))
			for (int i = 0; i < ipAddresses.length; i++) {
				String anAddress = ipAddresses[i].toString();
				int slashIndex = anAddress.indexOf("/");
				if (slashIndex != -1)
					anAddress = anAddress.substring(slashIndex + 1);
				ipAddressList.add(anAddress);
			}
		return ipAddressList;
	}

}
