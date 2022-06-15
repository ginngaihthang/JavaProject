package Assignment;

import java.util.Scanner;

public class Assignment8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your NRCNO: ");
		String nrc = sc.nextLine();
		String[] splits = nrc.split("\\/");
		String[] splits1 = nrc.split("\\)");
		
		String splits2 = splits[1];
		String[] splits3 = splits2.split("\\(");
		
		System.out.println("Township: " + splits3[0]);
		System.out.println("Number: " + splits1[1]);
		sc.close();
	}
}
