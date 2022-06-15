package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Full name: ");
		String name = br.readLine();
		System.out.print("Enter email: ");
		String email = br.readLine();
		System.out.print("Enter phone: ");
		String  phone = br.readLine();
		System.out.print("Enter education: ");
		String education = br.readLine();
		System.out.print("Enter income: ");
		double income = Double.parseDouble(br.readLine());
		System.out.print("Enter age: ");
		int age = Integer.parseInt(br.readLine());
		br.close();
		System.out.println("\nFull name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		System.out.println("Education: " + education);
		System.out.println("Income: " + income);
		System.out.println("Age: " + age);
		
	}
}
