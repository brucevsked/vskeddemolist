package com.vsked.pattern2;

public class SampleFactory {
	
	public static Human createHuman(String type){
		Human man =null;
		if("man".equals(type)){
			man=new Man();
		}else if("woman".equals(type)){
			man=new Woman();
		}else{
			man=null;
			System.out.println("undefined human type");
		}
		return man;
	}

}
