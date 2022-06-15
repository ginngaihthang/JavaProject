package Assignment.pkg7;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import day5.LocalDate_1;

class Employee {
	private String name;
	private String city;
	private String department;
	private int salary;
	private LocalDate publishDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Employee(String name, String city, String department, int salary, LocalDate publishDate) {
		super();
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", city=" + city + ", department=" + department + ", salary=" + salary
				+ ", publishDate=" + publishDate + "]";
	}
	
}
public class Stream_Assignment_2 {


	public static void main(String[] args) {
		Employee[] employee = {
			new Employee("Htet Htet", "Yangon", "Emectronics", 900000, LocalDate.of(1991, 10, 16)),
			new Employee("Cherry", "Yangon", "Electronics", 820000, LocalDate.of(1994, 8, 14)),
			new Employee("Kyaw Kyaw", "Yangon", "Electronics", 780000, LocalDate.of(1988, 9, 2)),
			new Employee("Aung Aung", "Mandalay", "IT", 600000, LocalDate.of(1995, 1, 11)),
			new Employee("Jeon",  "Mandalay", "IT", 600000, LocalDate.of(1997, 9, 01)),
			new Employee("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, LocalDate.of(1994, 12,10)),
			new Employee("Aye Aye", "Yangon", "HR", 500000, LocalDate.of(1992,10,10)),
			new Employee("Gay Gay", "Taung Gyi", "HR", 400000, LocalDate.of(1996,5,12)),
			new Employee("Phway Phway", "Monywa", "HR", 300000, LocalDate.of(1995, 9, 3)),
			new Employee("Ko Ko", "Monywa", "IT", 500000, LocalDate.of(1992, 11, 11))
		};
		List<Employee> salary = Arrays.asList(employee);
		
		System.out.println("The minimum salary of employees");
		Employee empMin = salary.stream()
						.min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
		System.out.println(empMin);
		
		System.out.println("\nThe youngest employee information");
		LocalDate youngest = salary.stream()
							.map(e -> e.getPublishDate())
							.max(LocalDate::compareTo)
							.get();
		System.out.println(youngest);
					
		System.out.println("\nCount all employee whose birthday is greater than or equal '1995-02-12'");
		long count = salary.stream()
				.filter(e -> e.getPublishDate().equals(LocalDate.of(1995, 02, 12)))
				.count();
				
		System.out.println(count);
			
		
		System.out.println("\nTotal salary");
		int total = salary.stream()
						.mapToInt(e -> e.getSalary())
						.sum();
		System.out.println(total);
			
					
		System.out.println("\nTotal salary of all employees");
		List<Integer> minsalary = salary.stream()	
							.map(e -> e.getSalary())
							.sorted(Collections.reverseOrder())
							.limit(3)
							.collect(Collectors.toList());				
		System.out.println(minsalary);					
			
		System.out.println("\nThe average salary of department ‘HR’");
		double average =salary.stream()
								.filter(e -> e.getDepartment().equals("HR"))
								.mapToDouble(e -> e.getSalary())
								.average()
								.getAsDouble();
		System.out.println(average);
		
		System.out.println("\nEmployee which gets smallest salary");
		Employee empsalary = salary.stream()
				.min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
				
		System.out.println(empsalary);
		
		System.out.println("\nThe highest salary of employee in each city");
		int empmaxsalary = salary.stream()
							.mapToInt(e -> e.getSalary())
							.max()
							.getAsInt();
		System.out.println(empmaxsalary);
				
		System.out.println("List of employee who got the same salary");
		List<String> same = salary.stream()
							.map(e -> e.getCity())
							.distinct()
							.collect(Collectors.toList());		
		System.out.println(same);
		
		System.out.println("\nList of employee names in each department");
		List<String> name = salary.stream()
								.map(e -> e.getName())
								.collect(Collectors.toList());
		System.out.println(name);
					
				
		
	}
}
