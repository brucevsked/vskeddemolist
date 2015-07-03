package com.vsked.test;

public class TestDynamicParameter {

	public static void main(String[] args) {
		getParameters();
		getParameters("1");
		getParameters(1,"2");
		getParameters("1",2,3);
		getParameters("1","2","3","4");
		getParameters(1,2,3,4,5);

	}
	
	public static String getParameters(Object... ss){
		String s="";
		outPutParam(ss);
		return s;
	}
	
	public static void outPutParam(Object... ss){
		for(Object o:ss)
			System.out.print(o+",");
		System.out.println();
		
	}

}
