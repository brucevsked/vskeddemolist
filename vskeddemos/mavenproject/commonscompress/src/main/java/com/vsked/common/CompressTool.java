package com.vsked.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

public class CompressTool {
	
	private static final int tarBuffer=1024;
	
	/**
	 * 压缩一个文件为tar
	 * @param sourceFile 源文件
	 * @param targetFile 打包后文件
	 * @throws Exception
	 */
	public static void tarCompressFile(String sourceFile,String targetFile) throws Exception {
		TarArchiveOutputStream taos=new TarArchiveOutputStream(new FileOutputStream(targetFile));
		File file=new File(sourceFile);
		TarArchiveEntry tae=new TarArchiveEntry(file.getName());
		tae.setSize(file.length());
		taos.putArchiveEntry(tae);
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		int count=0;
		byte[] data=new byte[tarBuffer];
		
		while((count=bis.read(data,0,tarBuffer))!=-1){
			taos.write(data,0,count);
		}
		
		bis.close();
		taos.closeArchiveEntry();
		taos.close();
	}
	
	/**
	 * 解包tar文件
	 * @param sourceFile
	 * @param targetFile
	 * @throws Exception
	 */
	public static void tarUnCompressFile(String sourceFile,String targetFile) throws Exception {
		TarArchiveInputStream tais=new TarArchiveInputStream(new FileInputStream(sourceFile));
		@SuppressWarnings("unused")
		TarArchiveEntry entry = null;
		 while ((entry = tais.getNextTarEntry()) != null){
			 File tmpFile=new File(targetFile);
			 OutputStream os=new FileOutputStream(tmpFile);
			 int count=0;
			 byte[] data=new byte[tarBuffer];
			 while ((count = tais.read(data)) != -1){
				 os.write(data, 0, count);
			 }
			 os.flush();
			 os.close();
		 }
		tais.close();
	}
	
	/**
	 * 压缩一个文件夹为tar
	 * @param sourceFolder 请以/结尾
	 * @param targetFile
	 * @throws Exception
	 */
	public static void tarCompressFolder(String sourceFolder,String targetFile) throws Exception {
		TarArchiveOutputStream taos=new TarArchiveOutputStream(new FileOutputStream(targetFile));
		File sourceF1=new File(sourceFolder);
		File[] files=sourceF1.listFiles();
		
		String pathNew=sourceFolder.substring(0,sourceFolder.length()-1);
		pathNew=pathNew.substring(pathNew.lastIndexOf("/")+1)+"/";

		for(File file:files){
		TarArchiveEntry tae=new TarArchiveEntry(pathNew+file.getName());
		tae.setSize(file.length());
		taos.putArchiveEntry(tae);
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		int count=0;
		byte[] data=new byte[tarBuffer];
		
		while((count=bis.read(data,0,tarBuffer))!=-1){
			taos.write(data,0,count);
		}
		
		bis.close();
		taos.closeArchiveEntry();
		}
		taos.close();
	}
	
	/**
	 * 解压包括一层文件夹的tar文件
	 * @param sourceFile 源tar文件
	 * @param targetFolder 请以/结尾
	 * @throws Exception
	 */
	public static void tarUnCompressFolder(String sourceFile,String targetFolder) throws Exception {
		TarArchiveInputStream tais=new TarArchiveInputStream(new FileInputStream(sourceFile));
		TarArchiveEntry entry = null;
		 while ((entry = tais.getNextTarEntry()) != null){
			 String entryName=entry.getName();
			 if(entryName.contains("/")){
				 String folderName=entryName.substring(0,entryName.indexOf("/"));
				 createDir(targetFolder+folderName);
			 }
			 File tmpFile=new File(targetFolder+entry.getName());
			 OutputStream os=new FileOutputStream(tmpFile);
			 int count=0;
			 byte[] data=new byte[tarBuffer];
			 while ((count = tais.read(data)) != -1){
				 os.write(data, 0, count);
			 }
			 os.flush();
			 os.close();
			
		 }
		tais.close();
	}
	
	/**
	 * 根据传入的路径创建目录如果存在则不创建
	 * @param destDirName 要创建的目录路径
	 * @return true创建目录成功 false 创建目录失败
	 */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        return dir.mkdirs();
    }

}
