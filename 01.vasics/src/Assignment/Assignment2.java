package Assignment;

import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Enter time,you go bed: ");
			int bed = sc.nextInt();
			System.out.print("Enter time,you getup: ");
			int getup = sc.nextInt();
			int time = getup+12 - bed;
		
			if(time >= 5 && time <= 8) {
				System.out.println("\nYour sleep time is "+ time + " h");
				System.out.println("You Take care your health well!");
			}
			else if(time <= 5) {
				System.out.println("\nYour sleep time is!"+ time + "h");
				System.out.println("You are very hardworking!");
			}
			else if(time > 8) {
				System.out.println("\nYour sleep time is!"+ time + "h");
				System.out.println("You are abnormal!");
			}
			System.out.println("Do you want to continue,press 'y' or quit 'n': ");
			String ch = sc.next();
			if(ch.equals("n")) {
				break;
			}
			
		}
		sc.close();
	}
}
