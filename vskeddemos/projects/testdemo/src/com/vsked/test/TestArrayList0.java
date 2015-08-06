package com.vsked.test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList0 {

	public static void main(String[] args) {
		testArrayList();
	}
	
	public static void testArrayListRemove0(){
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		//System.out.println(l.size());
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
	}
	
	public static void testArrayList(){
		List<String> dateList=new ArrayList<String>();
		dateList.add("Aug 4, 2015 9:52:06");
		dateList.add("Aug 4, 2015 9:52:07");
		dateList.add("Aug 4, 2015 9:52:08");
		dateList.add("Aug 5, 2015 9:52:06");
		dateList.add("Aug 5, 2015 9:52:07");
		dateList.add("Aug 5, 2015 9:52:08");
		System.out.println(dateList.contains("Aug 4, 2015 9:52:26"));
		
		for(String s:dateList){
			System.out.println(s);
		}
	}

}
