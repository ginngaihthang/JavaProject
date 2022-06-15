package day5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Period_Duration {
	public static void main(String[] args) {
		LocalDate startDate = LocalDate.parse("2019-09-25");
		LocalDate endDate = LocalDate.parse("2021-10-31");
		
		int month = Period.between(startDate,endDate).getMonths();
		int day = Period.between(startDate, endDate).getDays();
		
		System.out.println("no of months: " + month);
		System.out.println("No of days : " + day);
		
		LocalTime startTime = LocalTime.parse("11:30");
		LocalTime endTime = LocalTime.parse("12:00");
		
		long seconds = Duration.between(startTime, endTime).getSeconds();
		 System.out.println("No of seconds: " + seconds);
	}
}
