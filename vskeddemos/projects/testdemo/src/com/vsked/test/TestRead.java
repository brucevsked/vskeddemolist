package com.vsked.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class TestRead {

	public static void main(String[] args) throws Exception {
		String fname="c:/r.txt";
		int flength=5;
		int sIndex=2;
		
        //System.out.println(readFileByInputStream(fname,flength));
		
		//System.out.println(readFileByDataInputStream(fname,sIndex,flength));
		
		//System.out.println(readFileByRandomAccessFile(fname,sIndex,flength));
		
		
		
	}
	
	public static String readFileByInputStream(String fname,int flengh) throws Exception{
		byte[] b=new byte[flengh];
		InputStream fis=new FileInputStream(new File(fname));
		fis.read(b);
		fis.close();
		return new String(b);
	}
	
	public static String readFileByDataInputStream(String fname,int sIndex,int flength) throws Exception{
		InputStream fis=new FileInputStream(new File(fname));
		DataInputStream dis=new DataInputStream(fis);
		byte[] b=new byte[flength];
		dis.skipBytes(sIndex);
		dis.read(b);
		fis.close();
		dis.close();
		return new String(b);
	}
	
	public static String readFileByRandomAccessFile(String fname,int sIndex,int flength) throws Exception{
		RandomAccessFile acf=new RandomAccessFile(new File(fname), "r");
		byte[] b=new byte[flength];
		acf.skipBytes(sIndex);
		acf.read(b);
		acf.close();
		return new String(b);
	}

}
