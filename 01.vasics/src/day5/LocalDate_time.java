package day5;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDate_time {
	public static void main(String[] args) {
		LocalDateTime now= LocalDateTime.now();
		LocalDateTime datetime = LocalDateTime.of(2015,Month.OCTOBER,20,04,30);
		
		System.out.println("Current date time " + now); 
		System.out.println("Current Year: " + now.getYear());
		System.out.println("Current Month: " + now.getMonth());
		System.out.println("Current day: " + now.getDayOfMonth());
		System.out.println("Current hour: " + now.getHour());
		System.out.println("Current minute: " + now.getMinute());
		System.out.println("Current second: " + now.getSecond());
		
		System.out.println(datetime);
	}
}
