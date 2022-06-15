package day15;

import java.util.List;

class Employee {
	private String name;
	private int salary;
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Employee(String name, int salary, String city) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	
}
public class Mapping_1 {

	public static void main(String[] args) {
		
		List<Employee> employees = List.of(
				new Employee("Kyaw Kyaw",9800,"Yangon"),
				new Employee("Aung Aung",6000,"Mandalay"),
				new Employee("Mg Mg",10000,"Mandalay"),
				new Employee("Yuri",6000,"Yangon"),
				new Employee("Jeon",7800,"Monywa")
				);
		
		int max_salary = employees.stream()
								.mapToInt( emp -> emp.getSalary())
								.max()
								.getAsInt();
		int min_salary = employees.stream()
							.mapToInt(Employee::getSalary)
							.min()
							.getAsInt();
		System.out.println("Max salary: " + max_salary);
		System.out.println("Min Salary: "+ min_salary);
		
		List<Integer> salaries = employees.stream()
									.map(emp -> emp.getSalary())
									.filter(s -> s < 10000)
									.limit(3)
									.toList();
		System.out.println(salaries);
		int[] salaries1 = employees.stream()
								.filter(emp -> emp.getSalary() > 6000)
								.mapToInt(Employee::getSalary)
								.toArray();

		for(var s: salaries1)
			System.out.println(s);
//		List<String> cities = employees.stream()	
//								.map((emp) -> emp.getCity())
//								.distinct()
//								.collect(Collectors.toList));
//		System.out.println(cities);	
	}
}
