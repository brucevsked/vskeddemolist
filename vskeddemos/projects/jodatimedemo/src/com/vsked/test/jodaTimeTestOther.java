package com.vsked.test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.Seconds;

public class jodaTimeTestOther {

	public static void main(String[] args) throws ParseException {
		String dateStart = "2015-08-15 15:29:50";		
		String dateStop = "2015-08-18 18:39:58";		
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date d1 = fd.parse(dateStart);		
		Date d2 = fd.parse(dateStop);		
		test1(d1, d2);		
		test2(d1, d2);		
		test3(d1, d2);
	}

	public static void test1(Date d1, Date d2) {
		// ����ms
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.print("ʱ����");
		System.out.print(diffDays + " �� ");
		System.out.print(diffHours + " Сʱ ");
		System.out.print(diffMinutes + " ���� ");
		System.out.print(diffSeconds + " ��.");
		System.out.println();
	}

	public static void test2(Date d1, Date d2) throws ParseException {
		DateTime dt1 = new DateTime(d1);
		DateTime dt2 = new DateTime(d2);
		System.out.print("ʱ����");
		System.out.print(Days.daysBetween(dt1, dt2).getDays() + " �� ");
		System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " Сʱ ");
		System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60	+ " ���� ");
		System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60	+ " ��.");
		System.out.println();
	}

	public static void test3(Date d1, Date d2) {
		Interval interval = new Interval(d1.getTime(), d2.getTime());
		Period p = interval.toPeriod();
		System.out.println("ʱ����" + p.getDays() + " �� " + p.getHours()+ " Сʱ " + p.getMinutes() + " ����" + p.getSeconds() + " ��");
	}

}
