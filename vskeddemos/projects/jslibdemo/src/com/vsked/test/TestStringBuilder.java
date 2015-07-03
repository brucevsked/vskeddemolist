package com.vsked.test;

public class TestStringBuilder {
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		StringBuilder sb=new StringBuilder("{");
		for(int i=0;i<100000;i++) sb.append(i+",");
		sb.setLength(sb.length()-1);
		sb.append("}");
		long endTime =System.currentTimeMillis();
		System.out.println((endTime-startTime)+sb.toString());
		
	}

}
