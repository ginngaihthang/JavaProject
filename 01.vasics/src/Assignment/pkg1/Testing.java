package Assignment.pkg1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Testing {
	public static void InputFromUser() {
		Student[] student = new Student[4];
		Scanner sc = new Scanner(System.in);
		for(var i = 0; i < student.length;i++) {
			student[i] = new Student();
			//input from user
			System.out.format("Enter %s Student Id: ", i+1);
			int id = sc.nextInt();
			sc.nextLine();
			System.out.format("Enter %s Student name: ", i+1);
			String Name = sc.nextLine();
			System.out.format("Enter %s Student mark: ", i+1);
			int Mark = sc.nextInt();
			System.out.println();
			student[i].setStudent(id);
			student[i].setName(Name);
			student[i].setMark(Mark);
			
		}
		
		// Display Student data
		System.out.println("StuId \t"+ "Name\t" + "Mark");
		for(int j =0; j < student.length;j++) {
			student[j].Display();
		}
		
		//search Student with id
		boolean result = true;
		while(result) {
			System.out.println("\nEnter Student id to Search: ");
			int search = sc.nextInt();
			int index = -1;
			for(int k =0;k < student.length; k++) {
				if(student[k].FindStudentWithID(search)) {
					index = k;
					break;
				}
			}
			if(index == -1)	 {
				System.out.format("Student Id-%s Does not exist!", search);
			}else{
				System.out.println("Student id -> " +student[index].getStudent());
				System.out.println("Student name ->"+student[index].getName());
				System.out.println("Student mark ->"+student[index].getMark());
			}
			System.out.print("\nIf you want to continue, press y or quit n: ");
			String ch = sc.next();
			if(ch.equals("y") || ch.equals("Y")) {
				result =true;
			}else {
				result = false;
			}
		}
		
		//Max mark , min mark , average mark
		int max_mark = student[0].getMark();
		int min_mark = student[0].getMark();
		int total =0;
		int count = 0;
		for(int i = 0;i < student.length;i++) {
			total += student[i].getMark();
			count++;
			if(max_mark < student[i].getMark()) {
				max_mark =student[i].getMark();
			}
			if(min_mark > student[i].getMark()) {
				min_mark = student[i].getMark();
			}
		}
		System.out.println("Maximum mark is " + max_mark);
		System.out.println("Minimum mark is " + min_mark);
		System.out.println("Average mark is " + total/count);
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			InputFromUser();
		} catch (InputMismatchException e) {
			System.err.println("Must be number!");
		}
	}
}
