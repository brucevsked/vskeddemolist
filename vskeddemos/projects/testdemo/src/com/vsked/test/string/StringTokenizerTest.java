package com.vsked.test.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
//		testWebLogicLog();
//		testOther();
		testOther1();

	}
	
	public static void testWebLogicLog(){
		String s="<2015-8-13 下午04时01分50秒 CST> <Warning> <Deployer> <BEA-149004> <Failures were detected while initiating start task for application 'pkiLogin'.> ";
		StringTokenizer st=new StringTokenizer(s,"<");
		String str="";
		while(st.hasMoreElements()){
			str=st.nextToken();
			str=str.replace(">", "");
			System.out.println(str);
		}
	}
	
	public static void testOther(){
		String s="{1}{w}{or}{dd}";
		StringTokenizer st=new StringTokenizer(s,"{");
		String str="";
		while(st.hasMoreElements()){
			str=st.nextToken();
			str=str.replace("}", "");
			System.out.println(str);
		}
	}
	public static void testOther1(){
		String s="${hello1}${bak2}${cc3}${xman4}";
		StringTokenizer st=new StringTokenizer(s,"${");
		String str="";
		while(st.hasMoreElements()){
			str=st.nextToken();
			str=str.replace("}", "");
			System.out.println(str);
		}
	}

}
