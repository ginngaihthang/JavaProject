package day2;

import java.util.Scanner;

public class Const_variable {
	static final float RATE =	1.5f;
	static final int MIN_PRICE = 10;
	public static void main(String[] args) {
		//userinput
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Price: ");
		int price = sc.nextInt();
		
		if(price < MIN_PRICE) 
			price = MIN_PRICE;
		
		System.out.println("Price: " + price);
		System.out.println("Expense: " + (price * RATE));
		sc.close();
	}
}
