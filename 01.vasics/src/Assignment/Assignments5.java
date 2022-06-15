package Assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignments5 {
	public static void main(String[] args) {
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:m:ss a");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("dd");
		LocalTime now = LocalTime.now();
		LocalDate date = LocalDate.now();
		LocalDate date1 = LocalDate.now();
		
		String[] menus = {"Pizza", "Burger", "Milk Tea", "Spicy Noodle"};
		String[] townships = {"AA","BB","CC","DD"};
		int[] times = {15,30,10,45};
		System.out.println("******* Available Menu *******");
		for(int i = 0 ; i < menus.length; i++) {
			System.out.println((i+1)+"."+menus[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Please choose item: ");
		int num = sc.nextInt();
		if(num > 4 ) {
			System.out.println("Does not exist!");
			return;
		}
		
		System.out.println("\n******* Deliverable Township ********");
		for(int j = 0;j < townships.length;j++) {
			System.out.println((j+1)+ "." +townships[j]);
		}
		System.out.print("Please choose township: ");
		int num1 = sc.nextInt();
		if(num1 > 4 ) {
			System.out.println("We can't ");
			return;
		}
		System.out.println("***** Order Type *****");
		System.out.println("1. Order Now?");
		System.out.println("2. Preorder?");
		System.out.print("Please choose 1 or 2: ");
		int num2 = sc.nextInt();
		
		//Order now Information
		
		
		if(num2 == 1) {
			System.out.println("****** Your Order Information ******");
			for(int k = 1; k < menus.length+1;k++) {
				if(num == k) {
					num--;
					System.out.println("Item name: " + menus[num]);
					
					
				}
			}
			for(int k =1; k < townships.length+1; k++) {
				if(num1 == k) {
					num1--;
					System.out.println("Your address: " + townships[num1]);
					System.out.println("Duration: " + times[num2] + " mins");
					System.out.println("Arrival Time: " +f2.format(now.plusMinutes(times[num2])));
				}
			}
		}
		
		// PreOrder 
		if(num2 == 2) {
			System.out.print("Enter deliver date (dd): ");
			int num3 = sc.nextInt();
			int num4 = num3 - Integer.valueOf(f3.format(date1));
			for(int k =1; k < townships.length+1; k++) {
				if(num == k) {
					num--;
					System.out.println("****** Your Order Information ******");
					System.out.println("Your address: " + townships[num]);
					System.out.println("Duration: " + times[num] + " mins");	
					System.out.println("Arrival Date:" + f1.format(date.plusDays(num4)));
				}
				
			}
			
		}
	}
}
