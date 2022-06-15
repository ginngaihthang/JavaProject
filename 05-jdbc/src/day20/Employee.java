package day20;

import java.time.LocalDate;

public class Employee {

	private int empId;
	private String email;
	private String password;
	private String city;
	private double salary;
	private LocalDate birthday;
	public Employee(int empId, String email, String password, String city, double salary, LocalDate birthday) {
		super();
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.city = city;
		this.salary = salary;
		this.birthday = birthday;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public Employee() {
		
	}
}
