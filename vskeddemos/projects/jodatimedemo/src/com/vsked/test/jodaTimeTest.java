package com.vsked.test;

import com.vsked.util.DateTimeUtilVsked;



public class jodaTimeTest {

	public static void main(String[] args) {
		System.out.println("��ȡ��������:"+DateTimeUtilVsked.getCurrentDate("yyyy-MM-dd"));
		System.out.println("��ȡ����һ����:"+DateTimeUtilVsked.getMondayOfCurrentWeek());
		System.out.println("��ȡ����ĩ����:"+DateTimeUtilVsked.getSundayOfCurrentWeek());
		System.out.println("��ȡ����һ����:"+DateTimeUtilVsked.getMondayOfBeforeWeek());
		System.out.println("��ȡ����ĩ����:"+DateTimeUtilVsked.getSundayOfBeforeWeek());
		System.out.println("��ȡ����һ����:"+DateTimeUtilVsked.getMondayOfNextWeek());
		System.out.println("��ȡ����ĩ����:"+DateTimeUtilVsked.getSundayOfNextWeek());
		System.out.println("��ȡ���µ�һ������:"+DateTimeUtilVsked.getFirstDayOfCurrentMonth());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfCurrentMonth());
		System.out.println("��ȡ���µ�һ������:"+DateTimeUtilVsked.getFirstDayOfBeforeMonth());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfBeforeMonth());
		System.out.println("��ȡ���µ�һ������:"+DateTimeUtilVsked.getFirstDayOfNextMonth());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfNextMonth());
		System.out.println("��ȡ�����һ������:"+DateTimeUtilVsked.getFirstDayOfCurrentYear());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfCurrentYear());
		System.out.println("��ȡ�����һ������:"+DateTimeUtilVsked.getFirstDayOfBeforeYear());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfBeforeYear());
		System.out.println("��ȡ�����һ������:"+DateTimeUtilVsked.getFirstDayOfNextYear());
		System.out.println("��ȡ�������һ������:"+DateTimeUtilVsked.getLastDayOfNextYear());
		System.out.println("��ȡ��������:"+DateTimeUtilVsked.getFirstDayOfCurrentSeason()); //������δ���
//		System.out.println("��ȡ��������:"+DateTimeUtilVsked);
//		System.out.println("��ȡ��������:"+DateTimeUtilVsked);

	}
	
	

}