package Assignment.pkg2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);) {
			Teacher  teacher = new Teacher();
			System.out.print("Enter Name: " );
			String name = sc.nextLine();
			System.out.print("Enter NRC: ");
			String nrc = sc.nextLine();
			System.out.print("Enter Address: ");
			String address = sc.nextLine();
			System.out.print("Enter Phone: ");
			String phone = sc.nextLine();

			teacher.setName(name);
			teacher.setNrc(nrc);
			teacher.setAddress(address);
			teacher.setPhone(phone);
			teacher.showInfo();
			teacher.showIdentificationInfo();
			
			System.out.print("Enter position: ");
			String position = sc.nextLine();
			System.out.print("Enter department: ");
			String department = sc.nextLine();
			System.out.print("Enter salary: ");
			int salary = sc.nextInt();
			
			teacher.setPosition(position);
			teacher.setDepartment(department);
			teacher.setSalary(salary);
			
			sc.nextLine();
			System.out.print("Enter update position: ");
			String pos = sc.nextLine();
			System.out.print("Enter update salary: ");
			int sal = sc.nextInt();
			teacher.Promote(pos, sal);
			sc.nextLine();
			System.out.print("Enter new department: ");
			String newdepart = sc.nextLine();
			teacher.Transfer(newdepart);
			teacher.TeacherInfo();
		} catch (InputMismatchException e) {
			System.err.println("Must be number!");
		}
	}
}

