package com.vsked.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		//set date
		c.set(2011, 0, 1);
		Date d=c.getTime();
		System.out.println("a1|"+sdf.format(d));
		//current date
		d=Calendar.getInstance().getTime();
		
		System.out.println("b1|"+sdf.format(d));
		// date to sql date
		java.sql.Date sd=new java.sql.Date(d.getTime());
		//date to string
		System.out.println("c1|"+sdf.format(sd));
		//sql date to date
		d=new Date(sd.getTime());
		//sql date to string
		System.out.println("d1|"+sdf.format(d));

	}

}
