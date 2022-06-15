package Assignment;
import java.util.Scanner;

public class Assignment9 {
	String[] num = new String[3];
	Assignment9(String num) {
		int[] num1 = new int[3];
		for(int i = 0; i < 3;i++) {
			this.num[i] = num;
			num1[i] = Integer.parseInt(this.num[i]);
		}
	}
	public static void main(String[] args) {
	
		try(Scanner sc = new Scanner(System.in)) {
			int count = 0;
			int total = 0;
			String[] number = new String[3];
			for(int i =0;i < 3;i++) {
				System.out.print("Enter number: ");
				String num2 = sc.nextLine();
				number[i]=num2;
				Assignment9 assignment = new Assignment9(number[i]);
				
				total += Integer.parseInt(num2);
				count++;
			}
			int max_num = Integer.parseInt(number[0]);
			int min_num = Integer.parseInt(number[0]);
			for(int i = 0;i < 3 ;i++ ) {
				
				if(max_num  < Integer.parseInt(number[i])) {
					max_num = Integer.parseInt(number[i]);
					
				}
				if(min_num > Integer.parseInt(number[i])) {
					min_num = Integer.parseInt(number[i]);
				}	
			}
			System.out.println("Minimum number is -> "+min_num);
			System.out.println("Maximum number is -> "+max_num);
			System.out.println("Average: " + total/count);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	
	
	}

}
