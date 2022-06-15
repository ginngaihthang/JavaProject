package day2;

import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Full name: ");
		String name = sc.nextLine();
		System.out.print("Enter email: ");
		String email = sc.nextLine();
		System.out.print("Enter phone: ");
		String phone = sc.nextLine();
		System.out.print("Enter education: ");
		String education =  sc.nextLine();
		System.out.print("Enter income: ");
		double income = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		
		sc.close();
		System.out.println("Full name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		System.out.println("Education: " + education);
		System.out.println("Income: " + income);
		System.out.println("Age: " + age);
	}
}
