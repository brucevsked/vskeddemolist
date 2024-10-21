package com.vsked;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.List;


public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		Application app = new Application();
		app.cleanAll();
	}

	public void cleanAll() {
		cleanDump();
		cleanWindowsTemp();
		cleanUserTemp();
		cleanSteamTemp();
	}

	public String getCurrentOSUserName(){
        return System.getProperty("user.name");
	}

	public void cleanDump(){
		log.info("start clean dump folder");
		String currentOSUserName = getCurrentOSUserName();
		String dumpPath="C:/Users/"+currentOSUserName+"/AppData/Local/CrashDumps";
		List<File> fileLists= (List<File>) FileUtils.listFiles(new File(dumpPath),null,true);

		for(File file:fileLists){
			log.info("now clean:{}",file.getAbsolutePath());
			file.delete();//delete file
		}
		log.info("end clean dump folder");
	}

	public void cleanUserTemp(){
		log.info("start clean current user temp folder");

		String currentOSUserName = getCurrentOSUserName();
		String currentUserTempPath="C:/Users/"+currentOSUserName+"/AppData/Local/Temp";

		cleanPathFrom(currentUserTempPath);

		log.info("end clean current user temp folder");
	}

	public void cleanWindowsTemp(){
		log.info("start clean window temp folder");

		String windowsTempPath="C:/Windows/Temp";

		cleanPathFrom(windowsTempPath);

		log.info("end clean window temp folder");
	}

	public void cleanSteamTemp(){
		log.info("start clean steam temp folder");

		String currentOSUserName = getCurrentOSUserName();
		String steamPath="C:/Users/"+currentOSUserName+"/AppData/Local/Steam/htmlcache/Cache/Cache_Data";

		cleanPathFrom(steamPath);
		String steamJsCache="C:/Users/"+currentOSUserName+"/AppData/Local/Steam/htmlcache/Code Cache/js";
		cleanPathFrom(steamJsCache);

		log.info("end clean steam temp folder");
	}

	public void cleanPathFrom(String cleanPath){
		log.info("start clean window temp folder");

		String windowsTempPath=cleanPath;

		List<File> fileLists= (List<File>) FileUtils.listFilesAndDirs(new File(windowsTempPath),TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE);
		String currentFilePath="";
		ChronoZonedDateTime deleteTime=ZonedDateTime.now().minusDays(2);
		for(File file:fileLists){
			currentFilePath=file.getAbsolutePath();
			Path prepareDeleteFile= Paths.get(currentFilePath);
			try {
				BasicFileAttributes basicFileAttributes= Files.readAttributes(prepareDeleteFile, BasicFileAttributes.class);
				ZonedDateTime zdt=ZonedDateTime.parse(basicFileAttributes.lastModifiedTime().toString());
				if(zdt.isBefore(deleteTime)){
					log.info("now clean:{},{}",file.getAbsolutePath(),zdt.toString());
					if(file.isDirectory()){
						FileUtils.cleanDirectory(file);
						FileUtils.deleteDirectory(file);
					}else{
						file.delete();//delete file
					}
				}

			} catch (IOException e) {
				log.error("file get attribute error:",e);
			}

		}

		log.info("end clean window temp folder");
	}

}
