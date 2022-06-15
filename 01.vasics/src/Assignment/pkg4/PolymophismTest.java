package Assignment.pkg4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PolymophismTest {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);) {
			Shape[] shape = new Shape[2];
			
			System.out.print("Enter length and width of cube: ");
			int x = sc.nextInt();
			shape[0] = new Cube(x);
			System.out.print("Enter radius of cricle: ");
			int r = sc.nextInt();
			shape[1] = new Cricle(r);
			shape[0].Area();
			shape[0].Volume();
			
			shape[1].Area();
		} catch (InputMismatchException e) {
			System.err.println("Must be number!");
		}
		
		
	}
}
