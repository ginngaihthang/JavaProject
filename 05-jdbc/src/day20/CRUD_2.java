package day20;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD_2 {

	public static void main(String[] args) throws SQLException {
		saveMatipleEmployee();
	}

	private static void saveMatipleEmployee() throws SQLException {
		var empList = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		
		for(var i = 0;i <2 ;i++) {
			System.out.println("\nEnter data for employee "+(i+1));
			Employee emp = new Employee();
			
			System.out.print("Enter empno: ");
			emp.setEmpId(Integer.parseInt(sc.nextLine()));
			
			System.out.print("Enter emial: ");
			emp.setEmail(sc.nextLine());
			
			System.out.print("Enter password: ");
			emp.setPassword(sc.nextLine());
			
			System.out.print("Enter city: ");
			emp.setCity(sc.nextLine());
			
			System.out.print("Enter salary: ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			
			System.out.print("Enter birthday (yyy-mm-dd): ");
			emp.setBirthday(LocalDate.parse(sc.nextLine()));
			
			empList.add(emp);
		}
//		DatabaseHandler.saveEmployee(empList);
		DatabaseHandler.manageTransaction(empList);
		System.out.println("Success");
		
		
		
	}


	
}
