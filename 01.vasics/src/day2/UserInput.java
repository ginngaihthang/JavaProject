package day2;

import java.io.*;

public class UserInput {
	
	public static void main(String[] args) throws IOException {
		//create
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//operations
		System.out.print("Enter name: ");
		String name = br.readLine();
		System.out.print("Enter salary: ");
		double salary = Double.parseDouble(br.readLine());
		System.out.print("Enter age: ");
		int age = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println("\nName: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);
	}
	
}
