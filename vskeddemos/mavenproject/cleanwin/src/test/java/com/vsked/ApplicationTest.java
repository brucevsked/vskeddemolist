package com.vsked;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZonedDateTime;
import java.util.List;


public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	Application app = new Application();
	
	@Test
	public void cleanAll() {
		app.cleanAll();
	}

	@Test
	public void cleanDump(){
		app.cleanDump();
	}

	@Test
	public void cleanWindowsTemp(){
		app.cleanWindowsTemp();
	}

	@Test
	public void cleanWindowsSystemTemp(){
		app.cleanWindowsSystemTemp();
	}

	@Test
	public void cleanUserTemp(){
		app.cleanUserTemp();
	}

	@Test
	public void cleanNvidiaTemp(){
		app.cleanNvidiaTemp();
	}

	@Test
	public void cleanSteamTemp(){
		app.cleanSteamTemp();
	}

	@Test
	public void getCurrentOSUserName() {
		String userName = app.getCurrentOSUserName();
		log.info(userName);
	}

	@Test
	public void readFileNameToList(){
        String userName = app.getCurrentOSUserName();
		String path="C:/Users/"+userName+"/AppData/Local/CrashDumps/";



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
	public void readFileNameIncludeFolderToList(){
		String userName = app.getCurrentOSUserName();
		String path="C:/Users/"+userName+"/AppData/Local/Temp/";

		List<File> fileLists= (List<File>) FileUtils.listFilesAndDirs(new File(path),TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE);

		for(File file:fileLists){
			log.info(file.getAbsolutePath());
		}

	}

	@Test
	public void fileTimeAbout(){
		String path="E:/H2.7z";
		Path file= Paths.get(path);
		try {
			BasicFileAttributes basicFileAttributes= Files.readAttributes(file, BasicFileAttributes.class);
			log.info("create time:"+basicFileAttributes.creationTime());
			log.info("last modify time:"+basicFileAttributes.lastModifiedTime());
			log.info("last access time:"+basicFileAttributes.lastAccessTime());
		} catch (IOException e) {
			log.error("file get attribute error:",e);
		}
	}

	@Test
	public void beforeDateTime(){
		String s="2024-07-05T01:09:03.6181857Z";
		ZonedDateTime zdt=ZonedDateTime.parse(s);
		log.info("{}",zdt);
		log.info("{}",zdt.isBefore(ZonedDateTime.now()));
		log.info("{}",zdt.isBefore(ZonedDateTime.now().minusDays(3)));
	}

	
}
