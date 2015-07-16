package com.vsked.test;

import org.joda.time.DateTime;  
import org.joda.time.Days;  
import org.joda.time.Duration;  
import org.joda.time.Instant;  
import org.joda.time.LocalDate;  
import org.joda.time.LocalDate.Property;  
import org.joda.time.LocalTime;  
  
import com.google.common.base.Function;  
import com.google.common.base.Strings;  
import com.google.common.collect.FluentIterable;  
import com.google.common.collect.ImmutableList;  
  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.List;  
import java.util.Locale;  
  
/** 
 * <pre> 
 * Test.java 
 * @author kanpiaoxue<br> 
 * @version 1.0 
 * Create Time 2014��6��30�� ����8:10:08<br> 
 * Description : 
 * </pre> 
 */  
public class DateTimeExample {  
  
    private static final String FORMATE_DATE = "yyyy-MM-dd";  
    private static final String FORMATE_SECONDS = "HH:mm:ss";  
    private static final String FORMATE_FULL = FORMATE_DATE.concat(" ").concat(FORMATE_SECONDS);  
  
    /** 
     * <pre> 
     * @param args 
     * </pre> 
     */  
    public static void main(String[] args) {  
  
        // 107��֮�������  
        System.out.println(DateTime.now().dayOfYear().addToCopy(107).toString("yyyy-MM-dd"));  
        // ��ǰ�ܵ���һ������  
        System.out.println(String.format("min:%s, max:%s",DateTime.now().dayOfWeek().withMinimumValue().toString("yyyy-MM-dd"),
        		DateTime.now().dayOfWeek().withMaximumValue().toString("yyyy-MM-dd")));  
        // ��ǰ�µĵ�һ������һ��  
        System.out.println(String.format( "min:%s, max:%s",  DateTime.now().dayOfMonth().withMinimumValue().toString("yyyy-MM-dd"),  
                DateTime.now().dayOfMonth().withMaximumValue().toString("yyyy-MM-dd")));  
        // ��ǰ��ĵ�һ������һ��  
        System.out.println(String.format( "min:%s, max:%s",  DateTime.now().dayOfYear().withMinimumValue().toString("yyyy-MM-dd"),  
                DateTime.now().dayOfYear().withMaximumValue().toString("yyyy-MM-dd")));  
  
        DateTime start = new DateTime(2014, 5, 30, 20, 11, 40);  
        DateTime now = DateTime.now();  
        System.out.println("now:" + start.toString(FORMATE_DATE));  
        System.out.println("now format with Locale.CHINESE:"  
                + now.toString(FORMATE_DATE, Locale.CHINESE));  
        System.out.println("before now 11 days:" + now.minusDays(11).toString(FORMATE_DATE));  
        System.out.println("before now 15 hours:" + now.minusHours(15).toString(FORMATE_DATE));  
        System.out.println("after now 30 days:" + now.plusDays(30).toString(FORMATE_DATE));  
  
        Duration duration = new Duration(start, now);  
        System.out.println("duration.getStandardDays(): " + start.toString(FORMATE_FULL) + " �� "  
                + now.toString(FORMATE_FULL) + " ����������" + duration.getStandardDays());  
        System.out.println("duration.getStandardHours(): " + start.toString(FORMATE_FULL) + " �� "  
                + now.toString(FORMATE_FULL) + " ����Сʱ����" + duration.getStandardHours());  
  
        Calendar calendar = now.toCalendar(Locale.CHINESE);  
        System.out.println("with JDK interact��"  
                + new SimpleDateFormat(FORMATE_DATE).format(calendar.getTime()));  
        Calendar calendar1 = Calendar.getInstance();  
        System.out.println("Calendar:"  
                + new SimpleDateFormat(FORMATE_DATE).format(calendar1.getTime()));  
  
        DateTime a = new DateTime(new Date());  
        System.out.println("��ʽ����" + a.toString(FORMATE_DATE, Locale.CHINESE));  
        DateTime b = new DateTime(2014, 1, 1, 0, 0);  
        System.out.println("��ʽ����" + b.toString(FORMATE_DATE, Locale.CHINESE));  
  
        String timeString = "2006-01-26";  
        DateTime c = new DateTime(timeString);  
        System.out.println("parse��" + c.toString(FORMATE_DATE, Locale.CHINESE));  
  
        LocalDate localDate = new LocalDate(2009, 9, 6);// September 6, 2009  
        System.out.println("LocalDate:" + localDate.toString(FORMATE_DATE, Locale.CHINESE));  
        LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM  
        System.out.println("LocalTime:" + localTime.toString("HH:mm:ss", Locale.CHINESE));  
  
        LocalDate d = LocalDate.now();  
        LocalDate lastDayOfPreviousMonth = d.minusMonths(1).dayOfMonth().withMaximumValue();  
        System.out.println("��ϣ��������һ���µ����һ��:"  + lastDayOfPreviousMonth.toString(FORMATE_DATE, Locale.CHINESE));  
        Property e = d.minusWeeks(1).dayOfWeek();  
        System.out.println("���ܵ���һ��" + e.withMinimumValue().toString(FORMATE_DATE, Locale.CHINESE));  
        System.out.println("���ܵ����գ�" + e.withMaximumValue().toString(FORMATE_DATE, Locale.CHINESE));  
  
        System.out.println(".dayOfWeek().getAsText(Locale.CHINESE):"  
                + a.minusYears(1).dayOfWeek().getAsText(Locale.CHINESE));  
        System.out.println(".monthOfYear().getAsText(Locale.CHINESE):"  
                + a.minusYears(1).monthOfYear().getAsText(Locale.CHINESE));  
        System.out.println(".dayOfMonth().getAsText(Locale.CHINESE):"  
                + a.minusYears(1).dayOfMonth().getAsText(Locale.CHINESE));  
  
        System.out.println("Days.daysBetween:"  
                + Days.daysBetween(DateTime.parse("2014-06-27"), DateTime.parse("2014-07-02"))  
                        .getDays());  
  
        DateTime one = DateTime.parse("2014-06-27T13:23:01");  
        System.out.println(one.minuteOfDay()// ת���� minuteOfDay  
                .setCopy(11)// ���� minuteOfDay ����ֵΪ 11��Ҳ���� 11 ����  
                .toString(FORMATE_FULL));  
        System.out.println(one.hourOfDay().setCopy(0).toString(FORMATE_FULL));  
        System.out.println(one.hourOfDay().addToCopy(3)// �� hourOfDay �������� 3��Сʱ  
                .toString(FORMATE_FULL));  
        System.out.println("�Ƿ�����:" + one.minusMonths(4)// ��"2014-06-27"��ȥ4���µ�"2014-02-27"  
                .monthOfYear()// ת����monthOfYear��ģʽ  
                .isLeap()// �Ƿ�����  
        );  
  
        DateTime from = DateTime.parse("2014-06-27");  
        DateTime to = DateTime.parse("2014-07-02");  
        int count = Days.daysBetween(from, to).getDays() + 1;  
        ImmutableList.Builder<String> builder = ImmutableList.builder();  
        for (int i = 0; i < count; i++) {  
            builder.add(from.plusDays(i).toString(FORMATE_DATE));  
        }  
        List<String> dateStringList = builder.build();  
        for (String str : dateStringList) {  
            System.out.println(str);  
        }  
        /** 
         * <pre> 
         * --output: 
         * 2014-06-27 
         * 2014-06-28 
         * 2014-06-29 
         * 2014-06-30 
         * 2014-07-01 
         * 2014-07-02 
         * </pre> 
         */  
  
        // ���ڸ������� "2014-07-02" �õ�����2�µ�ͬһ�죬����2014-02-02  
        // ====== start ���������3�ַ�������Ȼ��������Щ����  
        DateTime two = DateTime.parse("2014-07-02");  
        String feb = two.monthOfYear().withMinimumValue().plusMonths(1).toString(FORMATE_DATE);  
        System.out.println("with " + two.toString(FORMATE_DATE) + " to get " + feb);  
        feb = two.monthOfYear().setCopy(2).toString(FORMATE_DATE);  
        System.out.println("with " + two.toString(FORMATE_DATE) + " to get " + feb);  
        feb = two.monthOfYear().addToCopy(-5).toString(FORMATE_DATE);  
        System.out.println("with " + two.toString(FORMATE_DATE) + " to get " + feb);  
        // ====== end  
        for (int i = 0; i < 10; i++) {  
            DateTime in = two.plusYears(i);  
            if (in.year().isLeap()) {  
                System.out.println(in.toString("yyyy") + " ������");  
            }  
        }  
  
        System.out.println(Strings.repeat("=", 100));  
  
        DateTime temp = DateTime.parse("2014-07-02")// ��ǰ����  
                .monthOfYear()// ����·�  
                .withMinimumValue()// ����·�����С����ֵ��һ��  
                .plusMonths(1);// ��һ���������һ���£����Ƕ���  
        List<Long> dateLongValues = getDaysOfMonth(temp);// �������������ĺ������б�  
        List<String> dates = FluentIterable.from(dateLongValues)  
                .transform(new Function<Long, String>() {  
                    public String apply(Long input) {  
                        DateTime d = new DateTime(input.longValue());  
                        return d.toString(FORMATE_DATE);  
                    }  
                }).toList();  
        /** 
         * <pre> 
         * -- output 
         * 2014-02-01 
         * 2014-02-02 
         * 2014-02-03 
         * 2014-02-04 
         * 2014-02-05 
         * 2014-02-06 
         * 2014-02-07 
         * 2014-02-08 
         * 2014-02-09 
         * 2014-02-10 
         * 2014-02-11 
         * 2014-02-12 
         * 2014-02-13 
         * 2014-02-14 
         * 2014-02-15 
         * 2014-02-16 
         * 2014-02-17 
         * 2014-02-18 
         * 2014-02-19 
         * 2014-02-20 
         * 2014-02-21 
         * 2014-02-22 
         * 2014-02-23 
         * 2014-02-24 
         * 2014-02-25 
         * 2014-02-26 
         * 2014-02-27 
         * 2014-02-28 
         * </pre> 
         */  
        for (String str : dates) {  
            System.out.println(str);  
        }  
  
        List<Long> hourLongValues = getHoursTimeOfDate(DateTime.now());  
        List<String> hours = FluentIterable.from(hourLongValues)  
                .transform(new Function<Long, String>() {  
  
                    public String apply(Long input) {  
                        DateTime d = new DateTime(input.longValue());  
                        return d.toString(FORMATE_FULL);  
                    }  
                }).toList();  
        /** 
         * <pre> 
         * -- output 
         * 2014-07-01 00:00:00 
         * 2014-07-01 01:00:00 
         * 2014-07-01 02:00:00 
         * 2014-07-01 03:00:00 
         * 2014-07-01 04:00:00 
         * 2014-07-01 05:00:00 
         * 2014-07-01 06:00:00 
         * 2014-07-01 07:00:00 
         * 2014-07-01 08:00:00 
         * 2014-07-01 09:00:00 
         * 2014-07-01 10:00:00 
         * 2014-07-01 11:00:00 
         * 2014-07-01 12:00:00 
         * 2014-07-01 13:00:00 
         * 2014-07-01 14:00:00 
         * 2014-07-01 15:00:00 
         * 2014-07-01 16:00:00 
         * 2014-07-01 17:00:00 
         * 2014-07-01 18:00:00 
         * 2014-07-01 19:00:00 
         * 2014-07-01 20:00:00 
         * 2014-07-01 21:00:00 
         * 2014-07-01 22:00:00 
         * 2014-07-01 23:00:00 
         * </pre> 
         */  
        for (String str : hours) {  
            System.out.println(str);  
        }  
  
        List<Long> monthLongValues = getMonthsOfYear(DateTime.now());  
        List<String> months = FluentIterable.from(monthLongValues)  
                .transform(new Function<Long, String>() {  
                    public String apply(Long input) {  
                        DateTime d = new DateTime(input.longValue());  
                        return d.monthOfYear().getAsText(Locale.CHINESE);  
                    }  
                }).toList();  
        /** 
         * <pre> 
         * -- output 
         * һ�� 
         * ���� 
         * ���� 
         * ���� 
         * ���� 
         * ���� 
         * ���� 
         * ���� 
         * ���� 
         * ʮ�� 
         * ʮһ�� 
         * ʮ���� 
         * </pre> 
         */  
        for (String str : months) {  
            System.out.println(str);  
        }  
  
        System.out.println(Strings.repeat("=", 100));  
        run();  
    }  
  
    /** 
     * <pre> 
     * @param date 
     * @return date �������Сʱ�б� 
     * ��ע�����������ʵ��ʹ�����岻����Ϊÿ�춼��24��Сʱ����������仯�� 
     * ��������Ӿ���Ϊ��չʾDateTime��API 
     * </pre> 
     */  
    public static List<Long> getHoursTimeOfDate(DateTime date) {  
        final ImmutableList.Builder<Long> hourTimeList = ImmutableList.builder();  
  
        DateTime firstHourTime = date.withTimeAtStartOfDay();  
        final DateTime nextDayFirstHourTime = firstHourTime.plusDays(1);  
        while (firstHourTime.isBefore(nextDayFirstHourTime)) {  
            hourTimeList.add(firstHourTime.getMillis());  
            firstHourTime = firstHourTime.plusHours(1);  
        }  
        return hourTimeList.build();  
  
    }  
  
    /** 
     * <pre> 
     * @param date 
     * @return date �����·ݵ������б� 
     * </pre> 
     */  
    public static List<Long> getDaysOfMonth(DateTime date) {  
        final ImmutableList.Builder<Long> dayList = ImmutableList.builder();  
  
        LocalDate firstDayOfMonth = date.toLocalDate().withDayOfMonth(1);  
        final LocalDate nextMonthFirstDay = firstDayOfMonth.plusMonths(1);  
        while (firstDayOfMonth.isBefore(nextMonthFirstDay)) {  
            dayList.add(firstDayOfMonth.toDateTimeAtStartOfDay().getMillis());  
            firstDayOfMonth = firstDayOfMonth.plusDays(1);  
        }  
        return dayList.build();  
    }  
  
    /** 
     * <pre> 
     * @param date 
     * @return date ������ݵ��·��б� 
     * ��ע�����������ʵ��ʹ�����岻����Ϊÿ�궼��12���£���������仯�� 
     * ��������Ӿ���Ϊ��չʾDateTime��API 
     * </pre> 
     */  
    public static List<Long> getMonthsOfYear(DateTime date) {  
        final ImmutableList.Builder<Long> monthList = ImmutableList.builder();  
  
        LocalDate firstMonth = date.toLocalDate().withDayOfMonth(1).withMonthOfYear(1);  
        final LocalDate nextYearFirstMonth = firstMonth.plusYears(1);  
        while (firstMonth.isBefore(nextYearFirstMonth)) {  
            monthList.add(firstMonth.toDateTimeAtStartOfDay().getMillis());  
            firstMonth = firstMonth.plusMonths(1);  
        }  
        return monthList.build();  
    }  
  
    /** 
     * <pre> 
     * ���������� 
     * </pre> 
     */  
    private static void run() {  
        runInstant();  
        System.out.println();  
        runDateTime();  
        System.out.println();  
    }  
  
    private static void runInstant() {  
        System.out.println("Instant");  
        System.out.println("=======");  
        System.out  
                .println("Instant stores a point in the datetime continuum as millisecs from 1970-01-01T00:00:00Z");  
        System.out.println("Instant is immutable and thread-safe");  
        System.out.println("                      in = new Instant()");  
        Instant in = new Instant();  
        System.out.println("Millisecond time:     in.getMillis():           " + in.getMillis());  
        System.out.println("ISO string version:   in.toString():            " + in.toString());  
        System.out.println("ISO chronology:       in.getChronology():       " + in.getChronology());  
        System.out.println("UTC time zone:        in.getDateTimeZone():     " + in.getZone());  
        System.out.println("Change millis:        in.withMillis(0):         " + in.withMillis(0L));  
        System.out.println("");  
        System.out.println("Convert to Instant:   in.toInstant():           " + in.toInstant());  
        System.out.println("Convert to DateTime:  in.toDateTime():          " + in.toDateTime());  
        System.out.println("Convert to MutableDT: in.toMutableDateTime():   "  
                + in.toMutableDateTime());  
        System.out.println("Convert to Date:      in.toDate():              " + in.toDate());  
        System.out.println("");  
        System.out.println("                      in2 = new Instant(in.getMillis() + 10)");  
        Instant in2 = new Instant(in.getMillis() + 10);  
        System.out.println("Equals ms and chrono: in.equals(in2):           " + in.equals(in2));  
        System.out.println("Compare millisecond:  in.compareTo(in2):        " + in.compareTo(in2));  
        System.out.println("Compare millisecond:  in.isEqual(in2):          " + in.isEqual(in2));  
        System.out.println("Compare millisecond:  in.isAfter(in2):          " + in.isAfter(in2));  
        System.out.println("Compare millisecond:  in.isBefore(in2):         " + in.isBefore(in2));  
    }  
  
    private static void runDateTime() {  
        System.out.println("DateTime");  
        System.out.println("=======");  
        System.out  
                .println("DateTime stores a the date and time using millisecs from 1970-01-01T00:00:00Z internally");  
        System.out.println("DateTime is immutable and thread-safe");  
        System.out.println("                      in = new DateTime()");  
        DateTime in = new DateTime();  
        System.out.println("Millisecond time:     in.getMillis():           " + in.getMillis());  
        System.out.println("ISO string version:   in.toString():            " + in.toString());  
        System.out.println("ISO chronology:       in.getChronology():       " + in.getChronology());  
        System.out.println("Your time zone:       in.getDateTimeZone():     " + in.getZone());  
        System.out.println("Change millis:        in.withMillis(0):         " + in.withMillis(0L));  
        System.out.println("");  
        System.out.println("Get year:             in.getYear():             " + in.getYear());  
        System.out  
                .println("Get monthOfYear:      in.getMonthOfYear():      " + in.getMonthOfYear());  
        System.out.println("Get dayOfMonth:       in.getDayOfMonth():       " + in.getDayOfMonth());  
        System.out.println("...");  
        System.out.println("Property access:      in.dayOfWeek().get():                   "  
                + in.dayOfWeek().get());  
        System.out.println("Day of week as text:  in.dayOfWeek().getAsText():             "  
                + in.dayOfWeek().getAsText());  
        System.out.println("Day as short text:    in.dayOfWeek().getAsShortText():        "  
                + in.dayOfWeek().getAsShortText());  
        System.out.println("Day in french:        in.dayOfWeek().getAsText(Locale.FRENCH):"  
                + in.dayOfWeek().getAsText(Locale.FRENCH));  
        System.out.println("Max allowed value:    in.dayOfWeek().getMaximumValue():       "  
                + in.dayOfWeek().getMaximumValue());  
        System.out.println("Min allowed value:    in.dayOfWeek().getMinimumValue():       "  
                + in.dayOfWeek().getMinimumValue());  
        System.out.println("Copy & set to Jan:    in.monthOfYear().setCopy(1):            "  
                + in.monthOfYear().setCopy(1));  
        System.out.println("Copy & add 14 months: in.monthOfYear().addCopy(14):           "  
                + in.monthOfYear().addToCopy(14));  
        System.out.println("Add 14 mnths in field:in.monthOfYear().addWrapFieldCopy(14):  "  
                + in.monthOfYear().addWrapFieldToCopy(14));  
        System.out.println("...");  
        System.out.println("Convert to Instant:   in.toInstant():           " + in.toInstant());  
        System.out.println("Convert to DateTime:  in.toDateTime():          " + in.toDateTime());  
        System.out.println("Convert to MutableDT: in.toMutableDateTime():   "  
                + in.toMutableDateTime());  
        System.out.println("Convert to Date:      in.toDate():              " + in.toDate());  
        System.out.println("Convert to Calendar:  in.toCalendar(Locale.UK): "  
                + in.toCalendar(Locale.UK).toString().substring(0, 46));  
        System.out.println("Convert to GregCal:   in.toGregorianCalendar(): "  
                + in.toGregorianCalendar().toString().substring(0, 46));  
        System.out.println("");  
        System.out.println("                      in2 = new DateTime(in.getMillis() + 10)");  
        DateTime in2 = new DateTime(in.getMillis() + 10);  
        System.out.println("Equals ms and chrono: in.equals(in2):           " + in.equals(in2));  
        System.out.println("Compare millisecond:  in.compareTo(in2):        " + in.compareTo(in2));  
        System.out.println("Compare millisecond:  in.isEqual(in2):          " + in.isEqual(in2));  
        System.out.println("Compare millisecond:  in.isAfter(in2):          " + in.isAfter(in2));  
        System.out.println("Compare millisecond:  in.isBefore(in2):         " + in.isBefore(in2));  
    }  
  
}  
