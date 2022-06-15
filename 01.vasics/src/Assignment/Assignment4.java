package Assignment;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Assignment4 {
	
	public static void main(String[] args) {
		String [] weekdays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
		String[] weekend = { "SATURDAY", "SUNDAY"};
		
		LocalDate now = LocalDate.now();
		DayOfWeek week = now.getDayOfWeek();
		System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		
		System.out.println("***********************");
		
		
		for(int i = 0;i < weekdays.length;i++) {
			if(weekdays[i].equals(week.toString())) {
				System.out.println("I have no time. I am studying Programming \r\n"+ "Language.");
			}
			
		}
		for(int j = 0; j < weekend.length; j++) {
			if(weekend[j].equals(week.toString())) {
				System.out.println("Today is my holiday!");
			}
		}
		
	}
}
