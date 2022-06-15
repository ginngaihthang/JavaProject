package Assignment;

import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many number you want to type:  ");
		int number = sc.nextInt();
		int zero =0;
		int positive =0;
		int negative =0;
		if(number > 0) {
			for(int i = 0;i < number;i++) {
				System.out.print("Enter any number: ");
				int num =sc.nextInt();
				if(num == 0)
					zero++;
				else if(num > 0)
					positive++;
				else if(num < 0)
					negative++;
			}
			System.out.println("\nNumber of zero: " + zero);
			System.out.println("Number of positive: " + positive);
			System.out.println("Number oof negative: " + negative);
		}
		
		sc.close();
		
	}
}
