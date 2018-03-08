package com.vsked.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class DictGen {
	public static String lineFlag="\r\n";
	public static char[] numberArr={'0','1','2','3','4','5','6','7','8','9'};
	public static char[] bigLetterArr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static char[] smallLetterArr={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static char[] symbolArr={};
	public static char[] tmpArry={'0','1'};
	public static char[] tmpArry1={'2'};
	
	public static StringBuffer sb=new StringBuffer();

	public static void main(String[] args) throws Exception {
		writeDict2();
	}
	
	public static void writeDict1() throws Exception{
		String savePath="d:/sdt0.txt";
		int length=4;
		genFile(length,numberArr,savePath);
		System.out.println("finish!");
	}
	
	public static void writeDict2() throws Exception{
		char[] ar3=attachArr(tmpArry,tmpArry1);
		String savePath="d:/sdt0.txt";
		int length=2;
		genFile(length,ar3,savePath);
		System.out.println("finish!");
	}
	
	public static void genFile(int length,char[] arr,String savePath) throws Exception{
		String s=gen(length, arr);
		writeFile(s,savePath);
	}
	
	public static String gen(int length,char[] arr){
		sb=new StringBuffer();
		per(new char[length], arr, length-1);
		return sb.toString();
	}
	
    public static void per(char[] buf, char[] chs, int len){  
        if(len == -1){
            for(int i=buf.length-1; i>=0; --i)  
                sb.append(buf[i]);  
            sb.append(lineFlag);
            return;
        }  
        for(int i=0; i<chs.length; i++){  
            buf[len] = chs[i];  
            per(buf, chs, len-1);  
        }  
    }
    
    public static void writeFile(String s,String path) throws Exception{
    	FileOutputStream outSTr = new FileOutputStream(new File(path));
        BufferedOutputStream buff = new BufferedOutputStream(outSTr);
        buff.write(s.getBytes());
        buff.flush();
        buff.close();
        outSTr.close();
    }
    
    public static char[] attachArr(char[] ar1,char[] ar2){
    	char[] ar3=new char[ar1.length+ar2.length];
    	System.arraycopy(ar1, 0, ar3, 0, ar1.length);
    	System.arraycopy(ar2, 0, ar3, ar1.length, ar2.length);
    	return ar3;
    }
}
