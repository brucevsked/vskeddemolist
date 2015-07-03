package com.vsked.test;

import com.vsked.util.HtmlTag;

public class TestEnum {
   
    public static void main(String[] args) {
    	String r1="";
    	for(HtmlTag ht:HtmlTag.values()){
    		System.out.println(ht);
    	}
    	
    	HtmlTag tag = HtmlTag.a;
    	switch (tag) {
    	case a:
    		System.out.println("aaa");
    	case b:
    		System.out.println("bbbb");
    		default:
    			break;
    	}
     }
}
