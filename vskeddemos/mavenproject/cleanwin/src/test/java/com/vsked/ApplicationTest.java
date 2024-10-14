package com.vsked;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;


public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	Application app = new Application();

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

	
}
