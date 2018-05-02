package com.vsked.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

public class CompressTool {
	
	private static final int tarBuffer=1024;
	
	/**
	 * 
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

}
