package com.vsked;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class CommonsIOTest {

	private static final Logger log = LoggerFactory.getLogger(Log4j2testNG7Application.class);

	@Test
	public void getFileLines() {
		try {
			log.trace("获取文件行数");
			String fileName = "d:/readme.txt";
			int lineCount1 = FileUtils.readLines(new File(fileName), "UTF-8").size();
			log.info("当前文件有:{}行",lineCount1);
		}catch (Exception e){
			log.error("文件获取异常!",e);
		}
	}

	@Test
	public void save(){
		try {
			log.info("覆盖写入");
		String fileName = "d:/readme1.txt";
		String content="abcdefg123中文";
		FileUtils.write(new File(fileName),content,"UTF-8");
		}catch (Exception e){
			log.error("文件写入异常!",e);
		}
	}

	@Test
	public void saveAppend(){
		try {
			log.info("追加写入");
			String fileName = "d:/readme1.txt";
			String content="天下英雄出你辈"+System.getProperty("line.separator");
			FileUtils.write(new File(fileName),content,"UTF-8",true);
		}catch (Exception e){
			log.error("文件写入异常!",e);
		}
	}

	@Test
	public void readToList(){
		try {
			log.info("读");
			String fileName = "d:/readme1.txt";
			List<String> linesList=FileUtils.readLines(new File(fileName),"UTF-8");
			for(String line:linesList){
				log.info(line);
			}
		}catch (Exception e){
			log.error("文件读取异常!",e);
		}
	}

	@Test
	public void readFileNameToList(){

		String path="D:\\economy\\documents\\剧本杀\\剧本\\红";

		/**
		 *  FileUtils.listFiles(File directory, String[] extensions, boolean recursive)
		 *  @param directory  要搜索的目录
		 *  @param extensions 文件扩展名, 如. {"java","xml"}. 如果为 null 则返回所有文件.
		 *  @param recursive  如果为true，则递归搜索所有子目录
		 */
		List<File> fileLists= (List<File>) FileUtils.listFiles(new File(path),null,true);

		for(File file:fileLists){
			log.info(file.getAbsolutePath());
		}

	}

	@Test
	public void listFileNameInFolder(){
		String path="E:/novel";
		List<File> fileList= (List<File>) FileUtils.listFiles(new File(path),null,true);
		for(File file:fileList){
			log.info(file.getAbsolutePath());
			log.info(file.getName());
		}

	}


	
}
