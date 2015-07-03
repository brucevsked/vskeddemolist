package com.vsked.test;

public class TestSwitch {
	public static void main(String[] args) {
		int tv=4;
		
		switch(tv){
		case 0:
			System.out.println("s:0");
			break;
		case 1:
			System.out.println("s:a");
			break;
		case 2:
			System.out.println("s:b");
			break;
		case 3:
			System.out.println("s:c");
			break;
		case 4:
			System.out.println("s:d");
			break;
		}
		
		String[] as={"0","a","b","c","d"};
		
		System.out.println("A1|"+as[tv]);
		
		
	}

}
