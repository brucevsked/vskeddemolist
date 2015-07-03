package com.vsked.test;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegular {
	
	public static void main(String[] args) {
		String st="a.html?v.Id={id}";
        st="a.html?v.Id={id}&pp={ok.id}&vv={jj.d}";
		List<String> al=getFormualKey(st);
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}
		String s="1111a1";
		System.out.println(isNumber(s));
	}
	
	public static List<String> getFormualKey(String st){
		String regx="\\{([^\\{]*)\\}";
		
		Matcher m = Pattern.compile(regx).matcher(st);
		List<String> arList=new LinkedList<String>();
		while(m.find()){
			arList.add(m.group());
		}
		return arList;		
	}
	
	public static boolean isNumber(String s){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(s).matches();    
	}

}
