package com.vsked.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class CompressFile {

	public static void main(String args[]) throws Exception {
//		compress("E:/testa1/1.jpg", "E:/testa1/avv1.zip");
		List<String> fileList=new LinkedList<String>();
		fileList.add("E:/testa1/1.jpg");
		fileList.add("E:/testa1/2.jpg");
		fileList.add("E:/testa1/3.jpg");
		compressEx(fileList, "E:/testa1/avv1.zip");
		//uncompress("C:/Users/vsked/Desktop/temps/demoV.rar", "C:/Users/vsked/Desktop/temps/ss1/");
		//scanZipFile("C:/ps.jar");
		//loadZipFile("C:/ps.jar", "ps.xml");
	}


	public static String readFileContentInZip(String zipFilePath, String inFileName) {
		String t = "";
		String jarFilePath = zipFilePath;
		String fileName = inFileName;
		File jarFile = new File(jarFilePath);
		if (jarFile.exists()) {
			try {
				ZipFile zipFile = new ZipFile(jarFile);
				ZipEntry tipEnty = zipFile.getEntry(fileName);
				ZipInputStream zin = new ZipInputStream(new FileInputStream(jarFilePath));
				ZipEntry entry;
				while ((entry = zin.getNextEntry()) != null) {
					if (entry.getName().equals(fileName)) {
						BufferedReader in = new BufferedReader(new InputStreamReader(zin));
						//BufferedReader in = new BufferedReader(new InputStreamReader(zin,Charset.forName("utf-8")));
						String s = "";
						while ((s = in.readLine()) != null) {
							t += s + "\n";
						}
					}// end if entry
					zin.closeEntry();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// end if jarFile
		return t;
	}

	public static List getZipFileNameList(String zipname) {
		List fileList = new ArrayList();
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
			ZipEntry entry;
			while ((entry = zin.getNextEntry()) != null) {
				// System.out.println(entry.getName());
				fileList.add(entry.getName());
				zin.closeEntry();
			}
			zin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileList;
	}

	public static void compress(String inFileOrFolderName,String outCompressFileName) throws IOException {
		File inFile = new File(inFileOrFolderName);
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outCompressFileName));
		zos.setComment("");
		zip(inFileOrFolderName, new File(outCompressFileName), zos, true, true);
		zos.close();
	}
	
	public static void compressEx(List<String> fileList,String outCompressFileName) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outCompressFileName));
		for(String inFileOrFolderName:fileList){
		File inFile = new File(inFileOrFolderName);
		zos.setComment("");
		zip(inFileOrFolderName, new File(outCompressFileName), zos, true, true);
		}
		zos.close();
	}

	public static void zip(String path, File basePath, ZipOutputStream zo, boolean isRecursive, boolean isOutBlankDir) throws IOException {
        File inFile = new File(path);
        File[] files = new File[0];
       if(inFile.isDirectory()) {    //directory
            files = inFile.listFiles();
        } else if(inFile.isFile()) {    //file
            files = new File[1];
            files[0] = inFile;
        }
       byte[] buf = new byte[1024];
       int len;
       for(int i=0; i<files.length; i++) {
            String pathName = "";
           if(basePath != null) {
               if(basePath.isDirectory()) {
                    pathName = files[i].getPath().substring(basePath.getPath().length()+1);
                } else {//file
                    pathName = files[i].getPath().substring(basePath.getParent().length()+1);
                }
            } else {
                pathName = files[i].getName();
            }
           pathName=(pathName.substring(pathName.indexOf("\\", 0)+1));
           if(files[i].isDirectory()) {
               if(isOutBlankDir && basePath != null) {    
                    zo.putNextEntry(new ZipEntry(pathName+"/"));    //
                }
               if(isRecursive) {    //
                    zip(files[i].getPath(), basePath, zo, isRecursive, isOutBlankDir);
                }
            } else {
                FileInputStream fin = new FileInputStream(files[i]);
                zo.putNextEntry(new ZipEntry(pathName));
               while((len=fin.read(buf))>0) {
                    zo.write(buf,0,len);
                }
                fin.close();
            }
        }
    }

	public static void uncompress(String inFileName,String outPath) throws Exception {
		File file = new File(inFileName);  // source compress file
		ZipFile zipFile = new ZipFile(file); 
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
		ZipEntry zipEntry = null;
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			String fileName = zipEntry.getName();
			File temp = new File(outPath + fileName);
			if (!temp.getParentFile().exists())
				temp.getParentFile().mkdirs();
			OutputStream os = new FileOutputStream(temp);
			InputStream is = zipFile.getInputStream(zipEntry);
			int len = 0;
			while ((len = is.read()) != -1)
				os.write(len);
			os.close();
			is.close();
		}
		zipInputStream.close();
	}

}
