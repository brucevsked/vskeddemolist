package com.vsked.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeUtilVkedTest {
	
	private static final Logger log=LogManager.getLogger(DateTimeUtilVkedTest.class);
	
	@Test
	public void getMonthLastDay(){
		String FORMATE_DATE = "dd";
		String s="";
		for(int i=1;i<13;i++){
		DateTime dt=new DateTime(2017, i, 1, 0,0);
		s=i+"";
		System.out.println((s.length()==1?"0"+s:s)+" "+dt.dayOfMonth().withMaximumValue().toString(FORMATE_DATE));
		log.debug((s.length()==1?"0"+s:s)+" "+dt.dayOfMonth().withMaximumValue().toString(FORMATE_DATE));
		}
	}

}
