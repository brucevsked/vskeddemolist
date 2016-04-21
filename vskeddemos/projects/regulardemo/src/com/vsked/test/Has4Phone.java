package com.vsked.test;

import java.util.LinkedList;
import java.util.List;

public class Has4Phone {

	public static void main(String[] args) {
		testHas4Number();

	}
	
	public static void testHas4Number(){
		List<String> phoneList=new LinkedList<String>();
		for(int i=0;i<100;i++){
			phoneList.add("17"+getLast(9, i));
		}
		System.out.println(phoneList.size());
		List<String> has4List=getNumberHasA(phoneList, "4");
		System.out.println(has4List.size());
		System.out.println(has4List);
		
	}
	
	public static List<String> getNumberHasA(List<String> phoneList,String num){
		List<String> resultList=new LinkedList<String>();
		for(String s:phoneList){
			if(s.indexOf(num)>=0) resultList.add(s);
		}
		return resultList;		
	}
	
	/**
	 * 不足几位补0
	 * @param length 总长度
	 * @param myNum 当前数字
	 * @return
	 */
	public static String getLast(int length,int myNum){
		String s=""+myNum;		
		for(int i=length-s.length();i>0;i--){
			s="0"+s;
		}		
		return s;		
	}

}
