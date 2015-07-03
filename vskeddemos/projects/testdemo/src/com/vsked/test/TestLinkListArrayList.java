package com.vsked.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLinkListArrayList {

	public static void main(String[] args) {
		
		List<Integer> rs=new LinkedList<Integer>();
		
		List<Integer> t1=new ArrayList<Integer>();
		
		for(int i=0;i<100000;i++) t1.add(i);
		
		List<Integer> t2=new LinkedList<Integer>();
		
		for(int i=0;i<100000;i++) t2.add(i);
		
		long time=System.currentTimeMillis(); 
		for(int i=0;i<t1.size();i++){ 
			if(t1.get(0)%2==0)rs.add(t1.get(0));
		    t1.remove(0);
		}
		System.out.println(rs.size()+"|t1:"+(System.currentTimeMillis()-time));
		
		rs=new LinkedList<Integer>();
		
		time=System.currentTimeMillis();
		for(int i=0;i<t2.size();i++){ 
			if(t2.get(0)%2==0)rs.add(t2.get(0));
		    t2.remove(0);
		}
		System.out.println(rs.size()+"|t2:"+(System.currentTimeMillis()-time));
		
	}

}
