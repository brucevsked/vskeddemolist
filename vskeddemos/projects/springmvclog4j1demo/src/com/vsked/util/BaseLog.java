package com.vsked.util;


import org.apache.log4j.Logger;

public class BaseLog {
	
	public static void getLog(Class<?> c,Exception e){
		Logger  log = Logger.getLogger(c.getClass());
		log.debug(c.getName()+"__debug__"+e.getMessage());
		log.info(c.getName()+"__info__"+e.getMessage());
		log.warn(c.getName()+"__warn__"+e.getMessage());
		log.error(c.getName()+"__error__"+e.getMessage());
		log.fatal(c.getName()+"__fatal__"+e.getMessage());
	}

}
