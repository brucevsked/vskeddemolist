package com.vsked.test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.vsked.util.FileOperate;

public class TestS1 {

	public static void main(String[] args) {
		String sourceFolder="D:/vskedHyfd/project/hyfdsim/testdata/exceldata/代理商/11月/11.2/11.2/";
		File f=new File(sourceFolder);
		
		List<String> fileList=new LinkedList<String>();
		String[] fArray=f.list();
		if(fArray!=null){
			for(String s:fArray){
				s=sourceFolder+s;
				File fv = new File(s);
				if(fv.isFile()) fileList.add(s);
			}
		}
		
		
		for(String s:fileList){
			System.out.println(getCustName(s));
		}
	}
	
	public static String getCustName(String filePath){
		return filePath.substring(filePath.lastIndexOf("/")+1,filePath.indexOf("-"));		
	}

}
