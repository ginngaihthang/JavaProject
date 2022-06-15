package day20;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;


public class CRUD_1 {
	private static void save_with_statemaent() {
		try(Connection con = MyConnection.createConnection()) {
			//create statement
			Statement stm = con.createStatement();
			
			String query = "INSERT INTO employees(empNo, email, password, salary, city, birthday)"
								+ "VALUES(1001,'aung@gmail.com','aung', '500000','Yangon', '1999-12-12')";
			
			int result = stm.executeUpdate(query);		
			System.out.println((result > 0) ?"sucess" :"fail");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void save_with_prepatestatemaent() {
		try(Connection con = MyConnection.createConnection()) {
			//create statement
			
			String query = "INSERT INTO employees(empNo, email, password, salary, city, birthday)"
								+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 1002);
			pstm.setString(2,  "hla@gmail.com");
			pstm.setString(3, "hla");
			pstm.setDouble(4, 1000000);
			pstm.setString(5, "Mandalay");
			pstm.setDate(6, Date.valueOf("1995-09-31"));
			
			// execute query
			int result = pstm.executeUpdate();
			System.out.println((result > 0) ?"sucess" :"fail");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
//		save_with_statemaent();
//		save_with_prepatestatemaent();
//		saveEmployee();
//		login();
//		viewAll();
		
		// update
//		  Scanner sc = new Scanner(System.in);
//		  System.out.print("Enter promote salary: ");
//		  double salary = Double.parseDouble(sc.nextLine());
//		  if(DatabaseHandler.promoteSalary(salary))
//		   System.out.println("Update success");
//		  else 
//		   System.out.println("Fail");
		  //sc.close();
		  
		  // delete
//		  Scanner sc = new Scanner(System.in);
//		  System.out.print("Enter city name to delete: ");
//		  String city = sc.nextLine();
//		  DatabaseHandler.deleteByCity(city);
//		  System.out.println("delete success");
	}

	private static void viewAll() {
		try(Scanner sc = new Scanner(System.in);
				Connection con = MyConnection.createConnection()) {
			
			String query = "SELECT * FROM employees ORDER BY email DESC";
			PreparedStatement  pstm = con.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("empNO") + "\t");
				System.out.print(rs.getString("password") + "\t");
				System.out.print(rs.getString("email")+ "\t");
				System.out.print(rs.getDouble("salary") + "\t");
				System.out.print(rs.getDate("birthday")+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void login() {
		try(Scanner sc = new Scanner(System.in);
				Connection con = MyConnection.createConnection()) {
			System.out.print("Enter email: ");
			String email = sc.nextLine();
			System.out.print("Enter password: ");
			String pass = sc.nextLine();
			
			String query = "SELECT * FROM employees Where email = ? AND password = ?";
			PreparedStatement  pstm = con.prepareStatement(query);
			pstm.setString(1,email);
			pstm.setString(2, pass);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				System.out.println("Login Success");
			else
				System.out.println("Login fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void saveEmployee() {
		
		try(Scanner sc = new Scanner(System.in);
				Connection con = MyConnection.createConnection()) {
			Employee emp = new Employee();
			System.out.println("Enter data for employee");
			System.out.print("emp no: ");
			emp.setEmpId(Integer.parseInt(sc.nextLine()));
			System.out.print("email: ");
			emp.setEmail(sc.nextLine());
			System.out.print("password: ");
			emp.setPassword(sc.nextLine());	
			System.out.print(" city: ");
			emp.setCity(sc.nextLine());
			System.out.print("salary: ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			System.out.print("birthday(yyy-mm-dd): ");
			emp.setBirthday(LocalDate.parse(sc.nextLine()));
			
//			save_with_statement(emp);
			save_with_prepareStatement(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void save_with_prepareStatement(Employee emp) {
		try(Connection con = MyConnection.createConnection()) {
	
			String insert = "INSERT INTO employees(empNo, email, password, salary, city, birthday)"
					+ "VALUES(?,?,?,?,?,?)";
					

				PreparedStatement pstm = con.prepareStatement(insert);
				pstm.setInt(1, emp.getEmpId());
				pstm.setString(2, emp.getEmail());
				pstm.setString(3, emp.getPassword());
				pstm.setDouble(4, emp.getSalary());
				pstm.setString(5, emp.getCity());
				pstm.setDate(6, Date.valueOf(emp.getBirthday()));
				
				pstm.executeUpdate();
				System.out.println("success");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

	private static void save_with_statement(Employee emp) {
		try(Connection con = MyConnection.createConnection()) {
			
			Statement stm = con.createStatement();
			
			String insert = "INSERT INTO employees(empNo, email, password, salary, city, birthday)"
					+ "VALUES(" + emp.getEmpId()+ ",'"
					+ emp.getEmail() + "','"
					+ emp.getPassword() + "','"
					+ emp.getSalary() + "','"
					+ emp.getCity() + "','"
					+ emp.getBirthday() + "')";
			
			System.out.println("query: " + insert);
			stm.executeUpdate(insert);
			System.out.println("success");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
