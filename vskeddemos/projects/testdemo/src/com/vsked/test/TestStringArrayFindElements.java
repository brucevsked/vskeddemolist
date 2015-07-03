package com.vsked.test;

import java.util.Arrays;
import java.util.List;

public class TestStringArrayFindElements {

	public static void main(String[] args) {
        String[] ts= new String[10000];
		
		String cpa="AC999";
		
		
		for(int i=0;i<ts.length;i++)ts[i]="ac"+i;
		long start=System.currentTimeMillis();
		List<String> sList=Arrays.asList(ts);
		System.out.println(sList.contains(cpa.toUpperCase()));
		System.out.println(sList.contains(cpa));
		System.out.println(sList.contains(cpa.toLowerCase()));
		long end=System.currentTimeMillis();
		System.out.println("list|"+(end-start));
		
		start=System.currentTimeMillis();
		for(int i=0;i<ts.length;i++){
			if(cpa.equals(ts[i].toLowerCase())){
				break;
			}
		}
		end=System.currentTimeMillis();
		System.out.println("list|"+(end-start));

	}

}
