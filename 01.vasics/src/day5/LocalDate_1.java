package day5;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDate_1 {
	public static void main(String[] args) {
		/// date
		LocalDate now =LocalDate.now();
		LocalDate locdate1 = LocalDate.of(2016,10,16);
		LocalDate locdate2 = LocalDate.parse("2016-10-16");
		
		System.out.println("Curreny date: " + now);
		System.out.println("Yesterday date: " + now.minusDays(1));
		System.out.println("Tomorrow date: " + now.plusDays(1));
		
		System.out.println("Current Year: " + now.getYear());
		System.out.println("Current Month: " + now.getMonth());
		System.out.println("Current day of week: " + now.getDayOfWeek());
		System.out.println("Current day of month: " + now.getDayOfMonth());
		
		System.out.println(now + "is leap yeat: " + now.isLeapYear());
		System.out.println(locdate1 + "is leap year: " + locdate1.isLeapYear());
		System.out.println(locdate1 + " is same to" + locdate2 + ":" + locdate1.equals(locdate2) );
		
		System.out.println();
		/// time
		LocalTime now1 = LocalTime.now();
		LocalTime time1 = LocalTime.of(11,03,45);
		LocalTime time2 = LocalTime.parse("04:30");
		
		System.out.println(now1);
		System.out.println(time1);
		System.out.println(time2);
		
		System.out.println("previous hour: " + now1.minusHours(1).getHour());
		System.out.println("Current hour: " + now1.getHour());
		System.out.println("Current minute: " + now1.getMinute());
		
		
		
	}
}
