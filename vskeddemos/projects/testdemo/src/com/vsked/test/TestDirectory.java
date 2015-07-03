package com.vsked.test;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vsked.util.VskTree;

public class TestDirectory {
	static int fcount=0;
	static Calendar c=Calendar.getInstance();
	static Set<String> folderSet=new HashSet<String>();
	static Map<String, String> folderMap=new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception {

	}
	public static void getFileList(File f) throws Exception{
		if(f.isDirectory()){
			fcount++;
			c.setTimeInMillis(f.lastModified());
			System.out.println(fcount+"|"+f.getName()+"||"+f.getParentFile());
			folderSet.add(f.getName());
			if(f.listFiles()!=null)
			for(File c:f.listFiles())
				getFileList(c);
		}else{
			fcount++;
			System.out.println(fcount+"|"+f.getName()+"||"+f.getParentFile());
			//TODO will check
			//c.setTimeInMillis(f.lastModified());
			//allFile.add(new FileInfo(folderCounter,f.getName(), f.getCanonicalPath(), getFileSize(f.length()), c.getTime().toLocaleString()));
		}
	}

}
