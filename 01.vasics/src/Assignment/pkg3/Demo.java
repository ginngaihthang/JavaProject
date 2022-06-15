package Assignment.pkg3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter rectangle Color: ");
			String color = sc.nextLine();
			System.out.print("Enter Rectangle Length: ");
			int length = sc.nextInt();
			System.out.print("Enter Rectangle Width: ");
			int width = sc.nextInt();
			
			Rectangle rectangle = new Rectangle(color,width, length);
			rectangle.dataShow();
			rectangle.Area();
		} catch (InputMismatchException e) {
			System.err.println("Must be number!");
		}
		
		
	}
}
