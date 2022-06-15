package day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Date_Time_Formater {
	
	public static void main(String[] args) {

		DateTimeFormatter date_format = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter time_format = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter date_time_format  = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime date_time = LocalDateTime.now();
		
		System.out.println("format1: " + date.format(date_format));
		System.out.println("Format2: " + time_format.format(time));
		System.out.println("formate2: " + time.format(time_format));
		System.out.println("format3: " + date_time.format(date_time_format));
		
		//custom pattern 
		System.out.println("------- Using custom Pattern -------\n");
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:m:s");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' h:m:ss");
		
		System.out.println("Default foramt: " + date);
		System.out.println("Custom format: " + f1.format(date));
		
		System.out.println("Default format: " + time);
		System.out.println("Custom format: " + time.format(f2));
		
		System.out.println("Default format: " + date_time);
		System.out.println("Custom format: " + f3.format(date_time));
		
		// localized pattern
		System.out.println("----------- Using Locallized Pattern -------");
		DateTimeFormatter format_1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		
		System.out.println("Default format: " + date);
//		System.out.println("localized format: " + date.format(format_1));
		System.out.format("Custom format: %s\n", date.format(format_1));
		
		System.out.format("Nmae: %s, Aye: %d", "su su",20);
		
		System.out.println("\nFull format: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
	}
}
