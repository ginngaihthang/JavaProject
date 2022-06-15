package day6;

import java.util.Scanner;

public class Exception_1 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number1 : ");
			int num1 = sc.nextInt();
			System.out.println("Enter number2: ");
			int num2 = sc.nextInt();
			
			int result = num1/num2;
			System.out.println("Result : " + result);
			sc.close();
		}catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		catch (NumberFormatException e) {
			System.err.println("User input must be number");
		}
		System.out.println("Outside try catch black");
	}
}
