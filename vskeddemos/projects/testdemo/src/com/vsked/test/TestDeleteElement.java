package com.vsked.test;

import java.util.LinkedList;
import java.util.List;

public class TestDeleteElement {

	public static void main(String[] args) {
		testDelListElement();
	}
	
	public static void testDelListElement(){
		List al=new LinkedList();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		
		for(int i=al.size()-1;i>=0;i--){
			System.out.println("current size:"+al.size()+"|current value:"+al.get(i));
			al.remove(i);
		}
	}

}
