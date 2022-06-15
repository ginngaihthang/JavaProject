package Assignment;

import java.util.Scanner;

public class Assignment10 {
	public static void main(String[] args) {
		 String[] division = {"AA", "BB", "CC", "DD", "EE", "FF","GG", "HH","II", "JJ", "KK", 
				 "LL", "MM", "NN"};
		 int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		
		try(Scanner sc = new Scanner(System.in);) {
			System.out.print("Enter your NRCNO: ");
			String nrc = sc.nextLine();
			String[] splits = nrc.split("\\/");
			String[] splits1 = nrc.split("\\)");
			String splits2 = splits[1];
			String[] splits3 = splits2.split("\\(");
			boolean result = true;
			
			for(int i =0; i < division.length; i++ ) {
				if(Integer.parseInt(splits[0]) == num[i]) {
					System.out.println("Division/state =" + division[i]);
					System.out.println("Township = " + splits3[0]);
					System.out.println("Number = " + splits1[1]);
					result = false;
				}
			}
			
			while(result) {
				for(int  j =0; j < division.length;j++) {
					if(Integer.parseInt(splits[0])!= num[j]) {
						throw new ArrayIndexOutOfBoundsException("Out of Range");
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			System.err.println("Input NRC is invalid!");
		}	
	}
}
