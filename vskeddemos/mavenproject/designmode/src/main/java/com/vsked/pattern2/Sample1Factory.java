package com.vsked.pattern2;

public class Sample1Factory {
	
	public static Human createHuman(Class<?> c){
		Human man =null;
		try{
			man=(Human)Class.forName(c.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("create exception");
		}
		return man;
	}

}
