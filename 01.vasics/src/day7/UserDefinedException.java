package day7;

import java.util.Scanner;

public class UserDefinedException {
	static void validateAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException ("age is not valid to smoke ");
		}
		else {
			System.out.println("You can Smoke");
		}
	}
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your age: ");
			int age = sc.nextInt();
			validateAge(age);
			
		}catch (InvalidAgeException e) {
			System.err.print(e.getMessage());
		}
	}
}
