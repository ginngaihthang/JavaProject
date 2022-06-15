package Assignment;

import java.util.Scanner;

public class Assignment11 {
	static void validateMark(int mark) throws InvalidMarkException{
		if(mark < 0 || mark > 100) {
			throw new InvalidMarkException("Mark is not valid");
		}
		else {
			System.out.println("Mark is " + mark);
		}
	}
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter your Eng mark: ");
			int eng = sc.nextInt();
			validateMark(eng);
			
			System.out.println("Enter your Math mark: ");
			int math = sc.nextInt();
			validateMark(math);
		}
		catch(InvalidMarkException e ) {
			System.err.print(e.getMessage());
		}
	}
	
}
