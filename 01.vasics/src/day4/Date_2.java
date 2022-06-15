package day4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Date_2 {
	public static void main(String[] args) {
		 LocalDate date1 = LocalDate.parse("2019-09-25");
		 LocalDate date2 = LocalDate.parse("2021-10-31");
		 
		 int month = Period.between(date1,  date2).getMonths();
		 System.out.println("No of month: " + month);
		 int days = Period.between(date1, date2).getDays();
		 System.out.println("No of days: " + days);
		 int years = Period.between(date1, date2).getYears();
		 System.out.println("No of Years: " + years);
		 
		 LocalTime time1 = LocalTime.parse("11:30");
		 LocalTime time2 = LocalTime.parse("12:00");
		 
		 long secs = Duration.between(time1, time2).getSeconds();
		 System.out.println("No of seconds: " + secs);
		 
	}
}
